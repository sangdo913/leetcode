class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        var n = grid.size
        var m = grid[0].size
        var dp = Array(n){IntArray(m){0x3f3f3f3f}}
        dp[0][0] = grid[0][0]
        grid.forEachIndexed{
            i,arr ->
            arr.forEachIndexed{
                j, v ->
                var up = if(i > 0) dp[i-1][j] else 0x3f3f3f3f
                var left = if(j > 0 ) dp[i][j-1] else 0x3f3f3f3f
                dp[i][j] = Math.min(dp[i][j], Math.min(up,left) + grid[i][j])
            }
        }
        return dp[n-1][m-1]
    }
}