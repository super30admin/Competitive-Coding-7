# Time Complexity : O(min(n, k) + k log(min(n, k))) : n- no.of elements
# Space Complexity: O(n)
# Approach : push a row or column into the heap, pop the root k times and each add remaining elements from its row/column.

import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        heap = []
        
        rows =  len(matrix)
        cols =  len(matrix)
        for i in range(rows):
            heapq.heappush(heap,(matrix[i][0],i,0))
            
        
        while (k > 0):
            
            element,i,j = heapq.heappop(heap)
            new_i = i
            new_j = j+1
            
            if (new_i < rows and new_j < cols):
                
                heapq.heappush(heap,(matrix[new_i][new_j],new_i,new_j))
                
            k-=1
            
        return element