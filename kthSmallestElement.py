# Time Complexity : O(n*n)
# Space Complexity : O(N) N = size of heap
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix or k < 0:
            return -1

        #put everything into my heap
        heap = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):    
                heappush(heap, matrix[i][j])
             
        #pop nxN - k times <- if max heap. k-1 min heap
        howManyTimesIPop = k-1
        while howManyTimesIPop:
            heappop(heap)
            howManyTimesIPop -= 1

        return heap[0]


#     matrix = [[1,5,9],
#              [10, 11, 13],
#              [12, 13, 15]]

#     print(kthSmallest(matrix, 8))