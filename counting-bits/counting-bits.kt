class Solution {
    fun countBits(n: Int): IntArray {
        return IntArray(n+1){n -> 
            var num = (n and 0x55555555) + ((n shr 1) and 0x55555555)
            num = (num and 0x33333333) + ((num shr 2) and 0x33333333)
            num = (num and 0x0f0f0f0f) + ((num shr 4) and 0x0f0f0f0f)
            num = (num and 0x00ff00ff) + ((num shr 8) and 0x00ff00ff)
            (num and 0x0000ffff) + ((num shr 16) and 0x0000ffff)
        }
    }
}