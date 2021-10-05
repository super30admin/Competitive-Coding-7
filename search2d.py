# // Time Complexity :O(log(m*n)), total size = row*column and binary search on it
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n=len(matrix)
        low=matrix[0][0]
        high=matrix[n-1][n-1]
        while(low<high):
            mid=(low+high)//2
            
            num=self.countel(matrix,mid)
            
            if num<k:
                low=mid+1
            else:
                high=mid
        return low
            
    def countel(self,matrix,mid):
        length=len(matrix)-1
        count=0
        for i in range(length+1):
            j=length
            print(matrix[i][j])
            while(j>=0 and matrix[i][j]>mid):
                
                j=j-1
            count=count+j+1
            
        return count
            
        