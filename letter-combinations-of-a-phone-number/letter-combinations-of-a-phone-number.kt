class Solution {
    var arr = arrayOf("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz")
    var myList =mutableListOf<String>()
    fun func(str: String, res: StringBuilder, i: Int) {
        if(i == str.length){
            myList.add(res.toString())
            return
        }
        arr[str[i].toInt()-48].map{
            res.setCharAt(i,it)
            func(str, res, i+1)
        }
        return 
    }
    fun letterCombinations(digits: String): List<String> {
        if(digits.length == 0) return listOf()
        var sb = StringBuilder(digits)
        func(digits, sb,0)
        return myList
    }
}