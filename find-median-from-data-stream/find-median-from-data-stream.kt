class MedianFinder() {

    /** initialize your data structure here. */
    var maxPq = PriorityQueue<Int>{i,j -> j - i}
    var minPq = PriorityQueue<Int>{i,j -> i - j}
    

    fun addNum(num: Int) {
        maxPq.add(num)
        minPq.add(maxPq.poll())
        if(maxPq.size < minPq.size){
            maxPq.add(minPq.poll())
        }
    }

    fun findMedian(): Double {
        return if(maxPq.size == minPq.size) (minPq.peek() + maxPq.peek()).toDouble()/2.0
        else maxPq.peek().toDouble()
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */