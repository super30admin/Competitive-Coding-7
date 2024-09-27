#time - O(nlogk)
#space- O(k) 
import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        min_heap=[]
        for i in range(0,len(matrix)):
            heappush(min_heap,(matrix[i][0],i,0))
        for _ in range(k):
            res,r,c=heappop(min_heap)
            if c<len(matrix[0])-1:
                heappush(min_heap,(matrix[r][c+1],r,c+1))
        return res
            
