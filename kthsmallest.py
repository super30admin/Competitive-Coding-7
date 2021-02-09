# TC: O(klogN)
# SC: O(N)

from heapq import heappush
from heapq import heappop
class Solution:
    
    class matrixParam:
        
        def __init__(self, val, i, j):
            self.i = i
            self.j = j
            self.val = val
        
        def __lt__(self, other):
            return self.val < other.val 
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        n  = len(matrix)
        q = []
        for j in range(n):
            heappush(q, self.matrixParam(matrix[0][j], 0, j))
        
        ct = 0
        while ct < k:
            cur = heappop(q)
            if cur.i < n-1:
                heappush(q, self.matrixParam(matrix[cur.i+1][cur.j], cur.i+1, cur.j))
            ct += 1
        
        return cur.val