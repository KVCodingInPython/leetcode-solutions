class Solution:
    def largestRectangleArea(self, heights: list[int]) -> int:
        max_area = 0
        heights.append(0)
        stack = []

        for i, h in enumerate(heights):
            while stack and heights[stack[-1]] > h:
                height_idx = stack.pop()
                height = heights[height_idx]
            
                # If stack is empty, width extends all the way to index 0
                width = i if not stack else (i - stack[-1] - 1)
                
                max_area = max(max_area, height * width)
            
            stack.append(i)

        # Restore original list state (optional)
        heights.pop()
        return max_area


        
