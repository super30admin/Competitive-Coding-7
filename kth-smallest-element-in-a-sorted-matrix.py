class Solution:
    # def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
    #     from heapq import heappush as push
    #     from heapq import heappop as pop
    #     heap=[]
    #     total=len(matrix)*len(matrix[0])
    #     for i in range(len(matrix)):
    #         for j in range(len(matrix[0])):
    #             push(heap,-matrix[i][j])
    #             if len(heap)>k:
    #                 pop(heap)
    #     return -1*pop(heap)
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n=len(matrix)
        l=matrix[0][0]
        h=matrix[n-1][n-1]
        def countless(matrix: List[List[int]],val:int):
            i=n-1
            j=0
            cnt=0
            while(i>=0 and j<n):
                if matrix[i][j]<=val:
                    cnt+=i+1
                    j+=1
                else:
                    i-=1
            return cnt
        while l<=h:
            mid=l+(h-l)//2
            # print(mid)
            cnt=countless(matrix,mid)
            if cnt<k:
                l=mid+1
            else:
                h=mid-1
        return l
        
        