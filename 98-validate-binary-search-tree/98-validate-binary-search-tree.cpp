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
tuple<long long,long long,bool> getval(TreeNode* n){
    if(!n) return{0xffffffffffLL,-0xffffffffLL, true};
    auto [lmin,lmax,lret] = getval(n->left);
    auto [rmin,rmax,rret] = getval(n->right);
    bool ret = lmax < n->val && rmin > n->val && lret && rret;
    return tie(min(lmin, (long long)n->val), max(rmax,(long long)n->val),ret);
}
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        auto [a,b,ret] = getval(root);
        return ret;
    }
};