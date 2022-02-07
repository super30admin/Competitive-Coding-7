class Solution:
    def count(self, matrix, mid):
        row = len(matrix)-1
        col = len(matrix[0])-1
        count = 0 
        for i in range(row+1):
            for j in range(col, -1, -1):
                if matrix[i][j] <= mid:
                    count += j+1
                    break  # After this "return count" line gets executed; it breaks out of both the loops as the matrix is sorted row wise and col wise . 
        return count
        
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        low = matrix[0][0]
        high = matrix[-1][-1]
        while low < high:
            mid = low + (high - low)//2
            count = self.count(matrix, mid)
            # print("mid, count", mid, count)
            if count >= k :
                high = mid 
            else:
                low = mid + 1
        return low
            
           
          
'''
Algorithm for k smallest elements:
1. Get the low and high value from the matrix 
2. Iterate until low < high and find the mid point
get the count of elements that are less than the mid point 
if count >= k : 
	h = mid 
else:
	l = mid+1 
return l 

Algorithm for fidning the count:
get the row and col of the matrix 
if the last element in a row <= mid --> increment 
					the count by num of col
if the last element is not <= then we decrement the 
col value by one and search again 

'''
