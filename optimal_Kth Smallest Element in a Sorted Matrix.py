#time : O(NlogN) where N = n^2
#space: O(1)
#optimal
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if(matrix==[]):
            return 0
        n=len(matrix)-1
        low=matrix[0][0]
        high=matrix[n][n]
        while(low<high):
            mid=low+(high-low)//2
            count=self.countlesser(matrix,mid,n)
            if(count<k):
                low=mid+1
            else:
                high=mid
        return low
    def countlesser(self,matrix,mid,n):
        count=0
        for i in range(n+1):
            j=n
            while(j>=0 and matrix[i][j]>mid):
                j-=1
            count+=j+1
        return count