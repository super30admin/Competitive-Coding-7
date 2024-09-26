"""

Given an n x n matrix where each of the rows and columns 
is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, 
not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

"""

# Time Complexity : O(n * nlogk)
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List
import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        h = list()
        
        m = len(matrix)
        n = len(matrix[0])
        
        for i in range(m):
            for j in range(n):
                heapq.heappush(h, matrix[i][j])
                
        heapq.heapify(h)
        
        for i in range(k-1):
            heapq.heappop(h)
        
        return h[0]
        
        
        