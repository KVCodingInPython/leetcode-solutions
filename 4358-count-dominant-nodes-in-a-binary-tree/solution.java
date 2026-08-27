/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SubTreeInfo {
    int maxVal;
    int dominantCount;

    SubTreeInfo(int maxVal, int dominantCount) {
        this.maxVal = maxVal;
        this.dominantCount = dominantCount;
    }
}

class Solution {
    public int countDominantNodes(TreeNode root) {
        return dfs(root).dominantCount;
    }

    private SubTreeInfo dfs(TreeNode node) {
        if (node == null) {
            return new SubTreeInfo(Integer.MIN_VALUE, 0);
        }
        SubTreeInfo left = dfs(node.left);
        SubTreeInfo right = dfs(node.right);

        int currentMax = Math.max(node.val, Math.max(left.maxVal, right.maxVal));

        int isDominant = (node.val == currentMax) ? 1 : 0;

        int totalCount = left.dominantCount + right.dominantCount + isDominant;

        return new SubTreeInfo(currentMax, totalCount);
    }
}
