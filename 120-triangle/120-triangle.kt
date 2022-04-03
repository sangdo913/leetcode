class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var n = triangle.size
        var minPath = IntArray(n){i->triangle[n-1][i]}
        for (i in n-2 downTo 0){
            for(j in 0..i){
                minPath[j] = Math.min(minPath[j],minPath[j+1]) + triangle[i][j]
            }
        }
        return minPath[0]
    }
}