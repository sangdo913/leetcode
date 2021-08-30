class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        var dp = IntArray(n*2)
        var len = IntArray(n*2)
        
        if(gas[0] - cost[0] > 0) {
            dp[0] = gas[0]-cost[0]
            len[0] = 1
        }
        if(n == len[0]) return 0
        
        for(j in 1 until dp.size) {
            var i = j%n
            dp[j] = Math.max(0, gas[i]-cost[i])
            if(gas[i] - cost[i] >= 0) {
                dp[j] = gas[i]-cost[i]
                len[j] = 1
            }
            
            if(dp[j-1] + gas[i] - cost[i] >= dp[j]) {
                dp[j] = dp[j-1] + gas[i] - cost[i]
                len[j] = len[j-1] + 1
            }   
            if(len[j] == n) return (i+1)%n
        }
        
        return -1
    }
}