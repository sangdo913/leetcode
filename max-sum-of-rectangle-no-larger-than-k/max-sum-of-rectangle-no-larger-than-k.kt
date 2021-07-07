class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        var res = -0x3f3f3f3f
        for(i in matrix.indices){
            var rowSum = IntArray(matrix[0].size)
            for(j in i .. matrix.lastIndex){
                var prevSum = TreeSet<Int>{i,j -> j-i}
                var sum = 0
                prevSum.add(0)
                for(c in matrix[0].indices){
                    rowSum[c] += matrix[j][c]
                    sum += rowSum[c]
                    var find = sum-k
                    var ret = prevSum.findLast{it >= find}
                    res = Math.max(res,ret?.let{sum - it}?: -0x3f3f3f3f)
                    
                    prevSum.add(sum)
                }
            }
        }
        return res
    }
}