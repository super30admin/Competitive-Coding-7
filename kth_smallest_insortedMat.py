from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        """
        TC:O(m*n)
        SC:O((m*n))
        """
        m=len(matrix)
        n=len(matrix[0])
        minheap=[]
        for i in range(m):
            for j in range(n):
                push(minheap, matrix[i][j])
                print(minheap)
                if len(minheap)> (m*n)-k+1 :
                    pop(minheap)
                print(minheap)
        # print(minheap)
        return minheap[0]
            
            