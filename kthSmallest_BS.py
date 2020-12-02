"""
Binary search solution 
Time Complexity 0(log N ) N =m*n element
SC=O(1)

"""

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if len(matrix)==0 or matrix is None:
            return -1
        
        m=len(matrix)
        n=len(matrix[0])
        
        left=matrix[0][0]
        right=matrix[m-1][n-1]
        
        while(left<right):
            mid=left+(right-left)//2
            counts=self.getcount(matrix,m,n,mid)
            print(counts,mid)
            if(counts<k):
                left=mid+1
            else:
                right=mid
        return left
            
            
    def getcount(self,matrix,m,n,mid):
        count=0
        j=n-1
        for i in range(0,m):
            while(j>=0 and matrix[i][j]>mid): #count also mid element
                j-=1
            count+=j+1
        return count
    
                
        

        