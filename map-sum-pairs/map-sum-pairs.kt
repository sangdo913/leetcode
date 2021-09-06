class MapSum() {
    var tries = Array(51*51){IntArray(26)}
    var values = IntArray(51*51)
    var v = IntArray(51*51)
    /** Initialize your data structure here. */
    var tid = 0
    
    fun insert(key: String, `val`: Int) {
        var now = 0
        for(c in key) {
            var conv = c.toInt() - 'a'.toInt()
            if(tries[now][conv] == 0) {
                tries[now][conv] = ++tid
            }
            now = tries[now][conv]
        }
        var change = `val` - v[now]
        v[now] = `val`
        now = 0
        for(c in key) {
            values[now] += change
            var nxt = c.toInt() - 'a'.toInt()
            now = tries[now][nxt]
        }
        values[now] += change
    }

    fun sum(prefix: String): Int {
        var now = 0
        for(c in prefix) {
            var nxt = c.toInt() - 'a'.toInt()
            if(tries[now][nxt] == 0) return 0
            now = tries[now][nxt]
        }
      return values[now]
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */