# Time complexity : O(n * log(n))
# Space complexity : O(1)
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n=len(matrix)
        l=matrix[0][0]
        r=matrix[n-1][n-1]

        def get_count(matrix,mid):
            j=n-1 #j is set to be last column
            cnt=0
            for i in range(len(matrix)):
                while j>=0 and matrix[i][j]>mid: #if last column is smaller, then all element in current row are smaller. If not then need to check each element in the current row.
                    j-=1
                cnt+=j+1 #if last col is smaller, then entire row is smaller -> j+1. Similary wherever j is after while loop -> j+1 are smaller than k in the current row.
            return cnt

        while l<r:
            mid=l+(r-l)//2
            cnt=get_count(matrix,mid)
            if cnt < k: #main logic is that if number of elements smaller than mid is less than k, then they have to be on the right hand side. -> Draw a matrix you'll get it.
                l = mid + 1
            else:
                r = mid
        return l
