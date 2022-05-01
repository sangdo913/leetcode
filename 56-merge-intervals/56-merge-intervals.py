class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        
        past = -0x3f3f3f3f
        last = -0x3f3f3f3f
        res = []
        for a,b in intervals:
            if last >= a:
                last = max(last,b)
            else:
                res.append([past,last])
                past,last = a,b
        
        res.append([past,last])                
        return res[1:]        
       