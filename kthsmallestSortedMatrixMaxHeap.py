 def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        import heapq
        hp = []
        #maxheap solution, complexity= O(n^2)
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix)):
                #
                heapq.heappush(hp,-1*matrix[i][j])
                if(len(hp)>k):
                    heapq.heappop(hp)
        return -1*heapq.heappop(hp)
        
