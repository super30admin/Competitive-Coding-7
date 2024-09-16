# TC: O(X + k logX) where X = min(len(matrix), k).
# SC: O(min(N, k)) where N = rows & colums of matrix, i.e. space will be the size of the heap.

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        
        for i in range(min(len(matrix), k)):
            heapq.heappush(heap, (matrix[i][0], i, 0))
        
        while k:
            curr, r, c = heapq.heappop(heap)
            if c < len(matrix) - 1: 
                heapq.heappush(heap, (matrix[r][c + 1], r, c + 1))
            
            k -= 1
        
        return curr
