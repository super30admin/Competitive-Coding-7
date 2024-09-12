-------------------------------- kth smallest element from matrix ---------------------------------------------
# Time Complexity : O(min(k,n)+k log k)+klog n
# Space Complexity : O(k)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I used heap to store the first elements of the rows, then I will iterate until my k becomes 0,
#and pop the element from heap. If the next element is present for the popped row and column then we will
#add that element into heap until our k becomes 0. Once my k becomes 0 I will return that element.



import heapq    
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return -1
        
        heap = []
        n = len(matrix)
        for i in range(min(k,n)):
            heapq.heappush(heap,(matrix[i][0], i,0))
        
        while k:
            ele, r,c = heapq.heappop(heap)
            if c+1<=n-1:
                heapq.heappush(heap, (matrix[r][c+1],r,c+1))
            k -=1
        
        return ele