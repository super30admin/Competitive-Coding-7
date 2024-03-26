'''
TC: O(nlogk) - n is the number of elements in the input array and 
                k is the capacity set for heap
SC: O(k) - Set capacity for heap
'''
import heapq
from typing import List

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        heap = []
        for i in range(ROWS):
            for j in range(COLS):
                heapq.heappush(heap,-matrix[i][j])
                if len(heap)>k:
                    heapq.heappop(heap)
        return -heapq.heappop(heap)
s = Solution()
print(s.kthSmallest([[1,5,9],[10,11,13],[12,13,15]],8))
print(s.kthSmallest([[-5]],1))