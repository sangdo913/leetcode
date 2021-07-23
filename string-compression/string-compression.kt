class Solution {
    fun compress(chars: CharArray): Int {
        var prev = 'X'
        var count = 0
        var len = 0
        var compression = {
            if(count == 1) {
               chars[len++] = prev 
            }
            else if(count > 1){
               chars[len++] = prev 
               var digit = count.toString()
               digit.forEach{chars[len++] = it}
            }
        }
        chars.forEach {
            if(prev == it){
                count++
            }
            else {
                compression()
                prev = it
               count = 1
            }
        }
        compression()
        return len
    }
}