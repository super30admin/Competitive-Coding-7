"""
Problem : 1

Time Complexity : 
minHeap - O(klog(min(k,n)))
Binary Search - O(n*log(max-min))

Space Complexity :
minHeap - O(n)
Binary Search - O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Kth Smallest Element in a Sorted Matrix

# Approach - 1
# Min Heap

class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """

        minheap=[]
        
        n=len(matrix)
        m=len(matrix[0])
        for i in range(min(n,k)):
            minheap.append((matrix[i][0],i,0))
        heapq.heapify(minheap)

        while k:
            value,r,c=heapq.heappop(minheap)
            if c<n-1:
                heapq.heappush(minheap,(matrix[r][c+1],r,c+1))
            k-=1
        return value

# Approach - 2
# Binary Search 

class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n=len(matrix)
        start=matrix[0][0]
        end=matrix[n-1][n-1]
        while start<end:
            mid=start+(end-start)/2
            smaller=matrix[0][0]
            larger=matrix[n-1][n-1]

            count,smaller,larger=self.countLessEqual(matrix,mid,smaller,larger)
            if count==k:
                return smaller
            if count<k:
                start=larger
            else:
                end=smaller
        return start
    
    def countLessEqual(self,matrix,mid,smaller,larger):
        count=0
        n=len(matrix)
        row=n-1
        col=0

        while row>=0 and col<n:
            if matrix[row][col]>mid:
                larger=min(larger,matrix[row][col])
                row-=1
            else:
                smaller=max(smaller,matrix[row][col])
                count+=row+1
                col+=1
        return count,smaller,larger