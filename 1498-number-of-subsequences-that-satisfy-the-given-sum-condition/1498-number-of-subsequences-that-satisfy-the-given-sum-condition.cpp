class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int j = 0;
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.size(); ++i) {
            if(nums[i]*2 <= target) res = (res+1)%1000000007;
            int s = i, e = nums.size();
            int t= target - nums[i];
            while(s < e) {
                int m = (s+e)/2;
                if(t < nums[m]) {
                    e = m;
                }
                else s = m+1;
            }
            j = s;
            if(j-i >= 2) {
                int mul = 2;
                int bit = j-i-1;
                int n = 1;
                for(int i = 0; i < 32; ++i) {
                    if(bit & (1<<i)){
                        n = (1LL*n*mul)%1000000007;
                    }
                    mul = (1LL*mul*mul)%1000000007;
                }
                n--;
                res = (res + n)%1000000007;
            }
        }
           
        return res;
    }
};