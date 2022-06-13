'''
Time: O(mnlogk)
Space: O()
'''


import heapq as hq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        n = len(matrix)
        heap = []
        for i in range(n):
            for j in range(n):
                hq.heappush(heap,-1*matrix[i][j])
                if len(heap)>k:
                    hq.heappop(heap)
                    
        return -hq.heappop(heap)