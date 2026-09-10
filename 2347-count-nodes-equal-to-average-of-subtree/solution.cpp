/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    int matching_count = 0;

    // Helper returns pair<sum, count>
    std::pair<int, int> dfs(TreeNode* node) {
        if (!node) return {0, 0};

        auto [left_sum, left_count] = dfs(node->left);
        auto [right_sum, right_count] = dfs(node->right);

        int current_sum = left_sum + right_sum + node->val;
        int current_count = left_count + right_count + 1;

        if (node->val == current_sum / current_count) {
            matching_count++;
        }

        return {current_sum, current_count};
    }

public:
    int averageOfSubtree(TreeNode* root) {
        matching_count = 0; // Reset counter
        dfs(root);
        return matching_count;
    }
};
