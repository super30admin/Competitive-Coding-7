class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n,m=len(matrix),len(matrix[0])
        def countSmaller(num):
            i,j,cnt=0,m-1,0
            while i<n and j>=0:
                if matrix[i][j]<num:
                    cnt+=j+1
                    i+=1
                else:
                    j-=1
            return cnt
        def helper():
            lo,hi=matrix[0][0],matrix[-1][-1]
            while lo<=hi:
                mid=(lo+hi)//2
                print(mid,countSmaller(mid))
                if countSmaller(mid)>=k:
                    hi=mid-1
                else:
                    lo=mid+1
            return hi
        return helper()