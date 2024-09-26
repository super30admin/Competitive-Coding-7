# Leetcode- 378 - Kth smallest element in a 2D array
# Time Complexity - O(NlogN) where n is the total elements in an array
# space complexity- O(1)

# Approach - Binary search method. First we find the mid element and then check the count number less than equal to mid elemnt.

class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n=len(matrix)
        low=matrix[0][0]
        high=matrix[n-1][n-1]
        
        while low<high:
            mid=low+(high-low)//2
            
            if self.count(matrix,mid)<k:
                low=mid+1
                print(self.count(matrix,mid))
                print(low)
            else:
                high=mid
                
        return low
            
            
            
    def count(self,matrix,mid):
        count=0
        j=len(matrix)-1
        i=0
        while i<len(matrix) and j>=0:
            if matrix[i][j]<=mid:
                count=count+j+1
                i=i+1
            else:
                j=j-1
        
        return count


