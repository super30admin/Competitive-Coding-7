#TC: O(nlogk)
#SC: O(n)
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        from heapq import heappush as push
        from heapq import heappop as pop
        heap=[]
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                push(heap,-matrix[i][j])
                if len(heap)>k:
                    pop(heap)
        return -1*pop(heap)