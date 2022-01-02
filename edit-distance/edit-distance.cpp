class Solution {
    vector<vector<int> > dp;
public:
    string *s1, *s2;
    int dfs(int n, int m){
        if((*s1).size() == n && (*s2).size() == m) return 0;
        if((*s1).size() == n) return (*s2).size() - m;
        if((*s2).size() == m) return (*s1).size() - n;
        int &ret = dp[n][m];
        if(ret != -1) return ret;
        ret = 0x3f3f3f3f;
        
        int temp;
        if((*s1)[n] == (*s2)[m]){
            ret = dfs(n+1,m+1);
        }
        temp = dfs(n+1, m+1) + 1;            
        if(temp < ret) ret = temp;
        temp = dfs(n+1, m) + 1;
        if(temp < ret) ret = temp;
        temp = dfs(n, m+1) + 1;
        if(temp < ret) ret = temp;
        return ret;
    }
    int minDistance(string word1, string word2) {
        dp.resize(word1.size(),vector<int>(word2.size(),-1));
        
        s1 = &word1;
        s2 = &word2;
        return dfs(0,0);
    }
};