"""
Min heap 
Time complexity O(NlogK)
space O(K)


"""
import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        pq=[(matrix[i][0],i,0) for i in range(len(matrix))]
        print(pq)
        heapq.heapify(pq)
        count=0
        while pq:
            val,r,c=heapq.heappop(pq)
            count+=1
            if(count==k):
                return val
            if(c+1)<len(matrix[r]):
                c+=1
                heapq.heappush(pq,(matrix[r][c],r,c))
        return -1
       