import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int):
        count = 1
        my_heap = []
        heapq.heapify(my_heap)
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if j == 0:
                    heapq.heappush(my_heap,(matrix[i][j], [i,j]))
                    break    
        while(count < k):
            elem,coordinates = heapq.heappop(my_heap)
            count += 1
            x,y = coordinates
            if y+1< len(matrix[0]):
                heapq.heappush(my_heap,(matrix[x][y+1],[x,y+1]))
        element,cor = heapq.heappop(my_heap)                
        return element  