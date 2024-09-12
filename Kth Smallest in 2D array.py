import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        heap = []
        
        for i in range(min(len(matrix[0]), k )):
            heapq.heappush(heap, (matrix[i][0], i, 0))
            
            
            
        while k:
            curr, r, c = heapq.heappop(heap)
            if c<len(matrix)-1:
                heapq.heappush(heap, (matrix[r][c+1], r, c+1))
            k-=1
        return curr                
        
        Time: O(min(len(matrix[0]), k ))
        Space: O(min(len(matrix[0]), k ))
            
