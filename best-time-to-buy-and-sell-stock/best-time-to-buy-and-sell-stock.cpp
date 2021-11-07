class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int mmin = 0x3f3f3f3f;
        int profit = 0;
        for(int i = 0; i < prices.size(); ++i){
            profit = max(profit, prices[i] - mmin);
            mmin = min(prices[i], mmin);
        }
        return profit;
    }
};