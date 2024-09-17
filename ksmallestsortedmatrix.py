
"""
 Kth Smallest Element in a Sorted Matrix
 Time Complexity: O(mn)]Space Complexity: O(size of heap)

"""
class Solution:
    import heapq
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
 
        heap = [] #maxheap
 
        
        for i in range(len(matrix)): #rows
            for j in range(len(matrix[0])):# cols
                heapq.heappush(heap,-1*matrix[i][j])
                if len(heap)>k:
                  heapq.heappop(heap)
        return -1 *heapq.heappop(heap)
             