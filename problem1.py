# // Time Complexity : O(mnlogk) 
# // Space Complexity : O(k) kth element
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(heap,matrix[i][j] * -1)
                if len(heap) > k:
                    heapq.heappop(heap)
        return heap[0] * -1
