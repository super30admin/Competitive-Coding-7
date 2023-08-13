# Time Complexity :O(NM log k)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode :Yes
from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        self.heap = []
        curr_size = 0
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                insert(self.heap, -1 * matrix[i][j])
                curr_size += 1
                if curr_size > k :
                    remove(self.heap)
        return -1 * remove(self.heap)