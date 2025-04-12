#Time Complexity: O(m^2 log k), where m is the number of rows/columns in the matrix, as we push each element into the heap and perform O(log k) operations for each element.
#Space Complexity: O(k), due to the heap storing at most k elements at any time.
import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        m = len(matrix)
        for i in range(0, m):
            for j in range(0, m):
                heapq.heappush(heap,-matrix[i][j])
                if(len(heap)>k):
                    heapq.heappop(heap)
        element = (-1)*heap[0]
        return element