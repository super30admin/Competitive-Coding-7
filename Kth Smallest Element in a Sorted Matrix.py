class Solution:
    #Solution 1
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        #Approach: Binary Search
        #Time Complexity: O(n * log(maxEl - minEl))
        #Space Complexity: O(1)
        #where, the matrix is n * n dimensional
        #and, maxEl and minEl are the greatest and smallest elements in the matrix
        
        low = matrix[0][0]
        high = matrix[-1][-1]
        
        while low < high:
            mid = low + (high - low) // 2
            count = self.countSmaller(matrix, mid)
            
            if count < k:
                low = mid + 1
            else:
                high = mid
                
        return low
    
    def countSmaller(self, matrix, target):
        count = 0
        col = len(matrix[0]) - 1
        
        for row in matrix:
            if row[col] <= target:
                count += (col + 1)
                
            else:
                while col >= 0 and row[col] > target:
                    col -= 1
                if col < 0:
                    break
                else:
                    count += (col + 1)
        
        return count
    
    #Solution 2
    """
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        #Approach: Min-heap
        #Time Complexity: O(min(n, k) + k log(min(n, k)))
        #Space Complexity: O(min(n, k))
        #where, the matrix is n * n dimensional
        
        n = len(matrix)
        heap = []
        for r in range(min(n, k)):
            heappush(heap, (matrix[r][0], r, 0))
            
        for i in range(k):
            val, r, c = heappop(heap)
            if c + 1 < n:
                heappush(heap, (matrix[r][c+1], r, c+1))
            
        return val
    """