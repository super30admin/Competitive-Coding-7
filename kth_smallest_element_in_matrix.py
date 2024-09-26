# tc : O(mn log k ) 
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        import heapq
        #heapq.heapify()
        li = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                li.append(matrix[i][j])
         
        heapq.heapify(li)
        
        res = 0
        for i in range(k):
            res = heapq.heappop(li)
        
        return res
