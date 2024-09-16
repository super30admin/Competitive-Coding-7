class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        '''
        Time Complexity: O(klog(min(len(matrix,k)))
        Space Complexity: O(min(len(matrix,k))
        '''
        import heapq
        i=0
        hp = []
        for i in range(0,min(k,len(matrix))):
            heapq.heappush(hp, (matrix[i][0],i,0))
        
        while k>0:
            e,r,c = heapq.heappop(hp)
            
            if(c<len(matrix)-1):
                heapq.heappush(hp, (matrix[r][c+1],r,c+1))
            
            k-=1
        
        return e
