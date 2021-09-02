class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var n = matrix.size
        var len = n-1
        for(i in 0 until n/2) {
            for(j in 0 until len) {
                var temp = matrix[i][i+j]
                matrix[i][i+j] = matrix[n-1-i-j][i]
                matrix[n-1-i-j][i] = matrix[n-1-i][n-1-i-j]
                matrix[n-1-i][n-1-i-j] = matrix[i+j][n-1-i]
                matrix[i+j][n-1-i] = temp
            }
            len-=2
        }
    }
}