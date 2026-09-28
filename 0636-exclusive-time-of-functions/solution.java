class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        int prevTime = 0;
        Stack<Integer> functionID = new Stack<>();
        for (String log : logs) {
            String[] parts = log.split(":");

            if (parts[1].equals("start")) {
                int funcId = Integer.parseInt(parts[0]);
                int startTime = Integer.parseInt(parts[2]);

                if (!functionID.isEmpty()) {
                    int parentId = functionID.peek();
                    result[parentId] += (startTime - prevTime);
                }
                functionID.push(funcId);
                prevTime = startTime;

            }
            else {
                int endTime = Integer.parseInt(parts[2]);
                int duration = endTime - prevTime + 1;
                int endFunctionId = functionID.pop();
                result[endFunctionId] += duration;
                prevTime = endTime + 1;
            }
                
        }
        return result;
        
    }
}
