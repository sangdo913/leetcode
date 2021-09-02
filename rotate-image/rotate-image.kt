class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var n = matrix.size
        var len = n-1
        for(i in 0 until n/2) {
            var lui = i
            var luj = i
            var rui = i
            var ruj = n-1-i
            var ldi = n-1-i
            var ldj = i
            var rdi = n-1-i
            var rdj = n-1-i
            for(j in 0 until len) {
                var temp = matrix[lui][luj]
                matrix[lui][luj] = matrix[ldi][ldj]
                matrix[ldi][ldj] = matrix[rdi][rdj]
                matrix[rdi][rdj] = matrix[rui][ruj]
                matrix[rui][ruj] = temp
                luj++
                rui++
                rdj--
                ldi--
            }
            len-=2
        }
    }
}