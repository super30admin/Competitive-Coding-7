"""
// Time Complexity : O(nlogk), 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
import heapq
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        heap=[]
        
        r=c=len(matrix)
        
        for i in range(r):
            for j in range(c):

                if len(heap)<k:
                    heapq.heappush(heap,-matrix[i][j]) #maxheap

                elif -matrix[i][j] > heap[0]: #if size exceeds k
                    heapq.heappop(heap)
                    heapq.heappush(heap,-matrix[i][j])
         
        return -heap[0]