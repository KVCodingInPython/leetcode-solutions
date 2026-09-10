# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def averageOfSubtree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.count = 0

        

        def findSubTree(node):
            if node == None:
                return (0,0)

            left_sum, left_count = findSubTree(node.left)
            right_sum, right_count = findSubTree(node.right)

            current_sum = left_sum + right_sum + node.val
            current_count = left_count + right_count + 1

            if node.val == (current_sum // current_count):
                self.count += 1
            return (current_sum, current_count)

        findSubTree(root)
        return self.count
            
    
            


        

        

    
        
