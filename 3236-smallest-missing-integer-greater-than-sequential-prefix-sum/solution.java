import java.util.HashSet;
class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> RecordNum = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            RecordNum.add(nums[i]);
        }

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++ ) {
            if ((nums[i] == nums[i-1] + 1)) {
                sum = sum + nums[i];
            
              
            }
            else {
                break;
            }
        }

        while (RecordNum.contains(sum)) {
            sum = sum + 1;
        }

        return sum;
            

        }
        
      


        

    





        
}
