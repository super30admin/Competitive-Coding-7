# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

# // Time Complexity : O(n*m logk), log k to push n*m elements on the heap
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Your approach: Similar to Kth largest element, just build a maxheap instead of minheap

import heapq as hq

class Solution:
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        heap= []
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                
                hq.heappush(heap, -1*(matrix[i][j]))
                
                if len(heap)>k:
                    hq.heappop(heap)
                    
        return -1*hq.heappop(heap)
        