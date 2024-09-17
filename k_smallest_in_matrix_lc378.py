"""
Name: Srindihi
Did it run on LC: yes
Time Complexity: O((m*n) logm*n) - Goint throught the array
Space Complexity: O(m*n) - Storing the element in 1D array

Logic: Store the elements in one D array, 
sort then and return the element in k-1 position
"""

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if len(matrix)==0:
            return -1
        
        row = len(matrix)
        col = len(matrix[0])
        arr = [0]*(row*col)
        
        for i in range(0,row):
            for j in range(0,col):
                arr[i*col + j] = matrix[i][j]
        
        arr.sort()
        return arr[k-1]