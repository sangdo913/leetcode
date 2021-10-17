class Solution {
    fun numTrees(n: Int): Int {
        var a = IntArray(20)
        a[0] = 1
        a[1] = 1
        for(i in 2 until 20) {
            for(j in 0 until i) {
                a[i] += a[j] *a[i-j-1]
            }
        }
        return a[n]
    }
}