'''
TC: O(nlogk)
SC: O(k)
'''
import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        rlen = len(matrix)
        if not rlen:
            return -1
        clen = len(matrix[0])
        
        arr = list()
        l = 0
        for i in range(rlen):
            for j in range(clen):
                if l < k:
                    heapq.heappush(arr, -1 * matrix[i][j])
                    l += 1
                else:
                    if -1 * matrix[i][j] >= arr[0]:
                        heapq.heappushpop(arr, -1 * matrix[i][j])
        
        return arr[0] * -1
                

        