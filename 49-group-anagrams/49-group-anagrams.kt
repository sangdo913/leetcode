class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var res = ArrayList<List<String>>()
        strs.groupBy{
            var s = it.toCharArray()
            Arrays.sort(s)
            String(s)
        }.forEach{
         k,v ->
            res.add(v)
        }
        return res
    }
}