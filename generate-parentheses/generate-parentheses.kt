class Solution {
    var res = ArrayList<String>()
    fun generateParenthesis(n: Int, m: Int = n, s:String = ""): List<String> {
        if(n == 0 && m == 0) {
            res.add(s)
            return res
        }
        if(n < m){
            val next = s+")"
            generateParenthesis(n, m-1, next)
        }
        if(n > 0) {
            val next = s + "("
            generateParenthesis(n-1, m, next)
        }
        return res
    }
}