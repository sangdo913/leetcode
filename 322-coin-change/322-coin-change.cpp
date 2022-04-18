int dp[10001];

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        memset(dp, 0x3f3f3f3f, sizeof(dp));
        dp[0] = 0;
        int n = coins.size();
        for(int i = 0; i <= amount; ++i){
            for(int j = 0; j < n;++j){
                if(i - coins[j] >= 0 && dp[i-coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i-coins[j]] + 1;
                }
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }
};