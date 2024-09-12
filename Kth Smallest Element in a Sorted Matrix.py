# TC : O(n)
# SC : O(k)
import heapq as hq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        Maxheap =[]
        
        for rows in matrix:
            for num in rows:
                hq.heappush(Maxheap,-num)
                if len(Maxheap)>k:
                    hq.heappop(Maxheap)
                    
        return -Maxheap[0]