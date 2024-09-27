class Solution:
            
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        # Binary Search Solution
        # TC : O(n^2 log (max value - min value))
        # SC = O(1)
        
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n-1][n-1]
        
        def count(matrix,mid): # Can take O(n^2 max)
            cnt = 0
            for i in range(len(matrix)):
                j = len(matrix)-1
                while j >=0 and matrix[i][j] > mid:
                    j -= 1
                cnt += j+1
            return cnt
        
        while(low < high): # Will take O(log(max value -min value)) time
            mid = low + (high-low)//2
            cnt = count(matrix,mid)
            if cnt < k:
                low = mid + 1
            else:
                high = mid
        return low
    
#         # Heap Solution
#         # Time: O(max(klogn,nlogn)) and k can be as large as n^2, Space: O(n)
        
#         n = len(matrix)

#         heap = []
#         for i in range(n):
#             heapq.heappush(heap,(matrix[i][0],i,0))

#         popped = None

#         for i in range(k):
#             popped = heapq.heappop(heap)
#             row = popped[1]
#             col = popped[2]

#             if col < n-1:
#                 heapq.heappush(heap,(matrix[row][col+1],row,col+1))
            
#         return popped[0]