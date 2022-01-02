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
map<int, int> summap;
int sum;

int getallnum(TreeNode* node, int now){
    if(!node) return 0;
    summap[now+node->val]++;
    int ret = summap[now+node->val-sum] - (sum == 0);
    if(node->left) ret += getallnum(node->left, now+node->val);
    if(node->right) ret += getallnum(node->right, now+node->val);
    summap[now + node->val]--;
    //cout << ret << ' ' << node->val << endl;
    return ret;
} 
class Solution {
public:
    int pathSum(TreeNode* root, int ssum) {
        if(!root) return 0;
        summap.clear();
        summap[0] = 1;
        sum = ssum;
        return getallnum(root, 0);
    }
};