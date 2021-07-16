class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        """Binary search
        Time complexity-O(log(mn))
        Space complexity-O(1)"""
        numrows=len(matrix)
        numCol=len(matrix[0])
        start=matrix[0][0]
        end=matrix[numrows-1][len(matrix[0])-1]
        if k==1:
            return start
        if k==numrows*numCol:
            return end
        while start<=end:
            mid=start+(end-start)//2
            print(start, mid, end)
            count=self.getCount(matrix,mid)
            # if count==k:
            #     return start
            if count<k:
                start=mid+1
            else:
                end=mid-1
        return start
            
    def getCount(self, matrix, ele):
        count=0
        for i in range(len(matrix)):
            j=len(matrix[0])-1
            while j>=0 and matrix[i][j]>ele:
                j-=1
            count+=j+1
        return count
        """Priority Queue Implementation
        Time complexity-O(m*n) where we are traversing through the whole matrix
        Space complexity-O(k) as heap contains k elements at any point"""
        # q=[]
        # for i in range(len(matrix)):
        #     for j in range(len(matrix[0])):
        #         heapq.heappush(q, -1*matrix[i][j])
        #         if len(q)>k:
        #             heapq.heappop(q)
        # return q[0]*-1
                