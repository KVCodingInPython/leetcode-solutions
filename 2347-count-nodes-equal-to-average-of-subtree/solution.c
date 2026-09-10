/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
void findSubTree(struct TreeNode* node, int* out_sum, int* out_count, int* matching_count) {
    int node_count = 0;

    if (node == NULL) {
        *out_sum = 0;
        *out_count = 0;
        return;
    }
    int left_count, left_sum, right_count, right_sum = 0;

    findSubTree(node->left, &left_sum, &left_count, matching_count);
    findSubTree(node->right, &right_sum, &right_count, matching_count);

    int current_sum = left_sum + right_sum + node->val;
    int current_count = left_count + right_count + 1;

    if (node->val == (current_sum / current_count)) {
        (*matching_count)++;
    }

    *out_sum = current_sum;
    *out_count = current_count;

} 
int averageOfSubtree(struct TreeNode* root) {
    int matching_count = 0;
    int total_sum = 0;
    int total_count = 0;
    findSubTree(root, &total_sum, &total_count, &matching_count);
    return matching_count;
}

