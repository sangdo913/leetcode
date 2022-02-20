int dp[1000][1000];
string ss;

int getdp(int l, int r) {
    if(l == r) return 1;
    if(l == r+1) {
        return ss[l] == ss[r+1];
    }
    int &ret = dp[l][r];
    if(ret != -1) return dp[l][r];
    ret = 0;
    if(ss[l] != ss[r]) return ret;
    ret = getdp(l+1, r-1);
    return ret;
}

class Solution {
public:
    string longestPalindrome(string s) {
        memset(dp, -1, sizeof(dp));
        int res = 0;
        ss = s;
        string ss;
        for(int i = 0; i < s.size(); ++i){
            for(int j = i+res; j < s.size(); ++j){
                if(getdp(i,j)){
                    res = j-i+1;
                    ss = string(s.begin() + i, s.begin() + j+1);
                }
            }
        }
        return ss;
    }
};