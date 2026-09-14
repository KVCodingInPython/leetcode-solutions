class Solution {
    public long shadowPairs(int[] nums) {
        // O(n) or O(n log n) complexity
        Stack<int[]> numOrder = new Stack<>();
        // Pop if num on top and num below top is greater than top
        // Push if num currently at top is less than num about to be pushed to stack
        // Stack in ascending order -> Largest numbers top, smallest numbers bottom of stack
        long shadow_pair_count = 0;
        for (int j = 0; j < nums.length; j++) {
            while (!numOrder.isEmpty() && nums[numOrder.peek()[0]] > nums[j]) {
                numOrder.pop();
            }
             // If the stack top is exactly equal to nums[j], we have a duplicate group
            if (!numOrder.isEmpty() && nums[numOrder.peek()[0]] == nums[j]) {
                // The current element can form a valid pair with every element 
                // that is STRICTLY SMALLER than this duplicate group value.
                // That amount is: (Total stack size) minus (the size of the duplicate group)
                int duplicateCount = numOrder.peek()[1];
                shadow_pair_count += (numOrder.size() - duplicateCount);
                
                // Add the current element to the stack, incrementing the duplicate count group
                numOrder.push(new int[]{j, duplicateCount + 1});
            } 
            else {
                // If the top element is strictly smaller than nums[j], 
                // every element currently in the stack is a valid shadow pair match.
                shadow_pair_count += numOrder.size();
                
                // Push current index, it's a unique value so duplicate count starts at 1
                numOrder.push(new int[]{j, 1});
            }
        }
        return shadow_pair_count;
    }
}
