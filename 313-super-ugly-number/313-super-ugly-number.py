class a:
    def __init__(self, tup):
        self.tup = tup
    def __lt__(self, other):
        return self.tup[0] < other.tup[0]
    
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        limit = 1<<32
        m = len(primes)
        pq = []
        isin = set()
        res = [1]
        li = [0]*100
        for i in range(m):
            heappush(pq, a((primes[i], i)))
        count = 1
        while(count < n):
            now, j = heappop(pq).tup
            li[j]+=1
            if now not in isin: 
                isin.add(now)
                res.append(now)
                count+=1
            heappush(pq, a((res[li[j]]*primes[j],j)))
            
            
        return res[-1]
                