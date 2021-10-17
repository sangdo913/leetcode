class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
      var dp = Array<IntArray>(m){IntArray(n)}
      dp[0][0] = 1
      for(i in 0 until m) {
          for(j in 0 until n) {
              dp[i][j] += (if(i> 0) dp[i-1][j] else 0) +  (if(j>0) dp[i][j-1] else 0)
          }
      }
      return dp[m-1][n-1]
    }
}