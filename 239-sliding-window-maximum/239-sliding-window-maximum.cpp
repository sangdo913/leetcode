int fenwick[100001*4];

int update(int i, int v, int l, int r, int p){
    if(p < l || r <= p) return -0x80000000;
    if(r-l == 1) {
        fenwick[i] = v;
        return v;
    }
    int m = (l+r)/2;
    fenwick[i] = max(fenwick[i], update(i*2, v, l, m, p));
    fenwick[i] = max(fenwick[i], update(i*2+1, v, m, r, p));
    return fenwick[i];
}

int myget(int i, int l, int r, int s, int e){
    if(e <= l || r <= s) return -0x80000000;
    if(s <= l && r <= e) {
        return fenwick[i];
    }
    int m = (l+r)/2;
    return max(myget(i*2, l,m,s,e), myget(i*2+1, m,r,s,e));
}
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        for(int i = 1; i < nums.size()*4; ++i){
            fenwick[i] = 0x80000000;
        }
        for(int i = 0; i < nums.size(); ++i) {
            update(1, nums[i], 0, nums.size(), i);
        }
        vector<int> res(nums.size()-k+1);
        for(int i = 0; i <= nums.size()-k; ++i){
            res[i] = myget(1, 0,nums.size(), i, i+k);
        }
        return res;
    }
};