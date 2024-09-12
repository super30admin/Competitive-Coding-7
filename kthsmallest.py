class Solution:
    
    """
    Desccription: kth smallest element in a matrix
    
    Time Complexity: O(n log n)
    Space Complexity: O(1)
    
    Approach: Using binary search
    - count elements less than k and 
      + increase mid point if count is less than k
      + decrease high point if count is greater
    - return either when low and high points match
    """
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
           
        if matrix == None: return 
        
        self.n_rows, self.n_cols = len(matrix), len(matrix[0])
        
        low = matrix[0][0]
        high = matrix[self.n_rows-1][self.n_cols-1]
        
        while low < high:
            mid = int(low + (high - low)/2)
            count = self.count_values(matrix, mid)
            if count < k:
                low = mid + 1
            else: high = mid
            print(high, low, mid)
                
        return low
    
    def count_values(self, matrix, mid):
        count = 0
        for val in [item for sublist in matrix for item in sublist]:
            if val < mid:
                count += 1

        return count
