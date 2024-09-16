
'''
time complexity: o(nlogn)
n is total elements
space complexity O(n) //space occupied by heap
'''
import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        ls = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(ls,-matrix[i][j])
                if(len(ls)>k):
                    heapq.heappop(ls)
        return -ls[0]

        