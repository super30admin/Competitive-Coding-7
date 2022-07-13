# Approach : Heap
# TC: Heap construction takes min(k,n) time and then we pop k times so O(min(k,n) + k*log(min(k,n)))
# SC: O(min(k,n))
import heapq as hq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        
        
        for i in range(len(matrix)):
            for j in range(len(matrix)):
                # push elements on to the heap - upto min(n,k) times then break
                if len(heap) == min(len(matrix),k):
                    break
                hq.heappush(heap, (matrix[i][j], i, j)) # push element and its row/col so we can compute its neighbor
        
        # remove k-1 elements from the heap and add their neighbors below (r+1) location to heap
        # until it is in bounds
        for i in range(k-1):
            _,r,c = hq.heappop(heap)
            if r + 1 < len(matrix):
                hq.heappush(heap, (matrix[r+1][c], r+1,c))
        # after k-1 times, when you pop the heap kth time that is your result
        return hq.heappop(heap)[0]