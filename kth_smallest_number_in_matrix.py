class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        res=[]
        N=len(matrix)
        for i in range(min(k,N)):
            res.append((matrix[i][0],i,0))
        heapq.heapify(res)
        while k:
            element,r,c=heapq.heappop(res)
            if c<N-1:
                heapq.heappush(res,(matrix[r][c+1],r,c+1))
            k-=1
        return element
#Time-complexity: O(X+klog(X))
#Space-Complexity:O(X)