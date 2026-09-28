class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currentStreamNum = 1;
        
        for (int num : target) {
            // Push and Pop the numbers that are skipped in the target array
            while (currentStreamNum < num) {
                operations.add("Push");
                operations.add("Pop");
                currentStreamNum++;
            }
            
            // When currentStreamNum matches the target number, Push and keep it
            operations.add("Push");
            currentStreamNum++;
        }
        
        return operations;
    }
}

            
