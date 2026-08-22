class Solution {
    public int maxArea(int[] height) {
        int max = height[0];
        int min = height[0];
        int max_area = 0;
        int width = 0;
        int height_ = 0;
        int right = height.length - 1;
        int area = 0;
        int left = 0;
        while (left < right) {
            width = right - left;
            if (height[left] < height[right]) {
                height_ = height[left];
            }
            else {
                height_ = height[right];
            }
            area = height_ * width;
            if (max_area < area) {
                max_area = area;
            }
            System.out.println(max_area);
            if (height[right] < height[left]) {
                right -= 1;
            }
            else {
                left += 1;
            }

        }
        return max_area;
           
    }
      
     
}

