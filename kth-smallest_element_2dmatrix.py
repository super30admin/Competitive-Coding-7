// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we used a custom comparator to implement min heap in this problem.we insert the first col elements in the min heap with their row and col.then we pop the min element in the heap using min heap and get row and col from that element and then increment ur col and then add thah element to the heap.In this way if we want kth smallest element we do this for k times and then pop also the min element in the same itertion then we get the kth smallest element from the heap.
# # using min heap
# Time complexity --> o(klogn) where n=len(matrix)
# space complexity --> o(logk)
import heapq
class Node:
    def __init__(self,val,row,col):
        self.val=val
        self.row=row
        self.col=col
        
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        Node.__lt__=lambda x,y:x.val<y.val
        h=[]
        m=len(matrix)
        i=0
        for j in range(m):
            heapq.heappush(h,(matrix[j][0],j,i))
        while k>0:
            ele=heapq.heappop(h)
            row1=ele[1]
            col1=ele[2]+1
            # print(ele,len(h),row1,col1)
            if row1<m and col1<m:
                heapq.heappush(h,(matrix[row1][col1],row1,col1))
            k=k-1
        return(ele[0])
        



// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In python there is no max heap inbuilt function so i multiplied by -1 to every element while inserting into the min heap to make a max heap.
solved this problem using max heap.we make a heap of size k and then insert the elements till it is filled.when filled during insertion of another value we pop the max element from the heap and then we do the same for all the elements.when it is done for all the values then when we pop an element from the max heap we get the kth smallest element for the 2d matrix.

# using max heap
# Time complexity --> o(mn logk)
# space complexity --> o(logk)
import heapq
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        m=len(matrix)
        if m==0 or matrix==None:
            return 0
        h=[]
        for i in range(len(matrix)):
            j=0
            while(j<m):
                if len(h)<k:
                    heapq.heappush(h,-1*matrix[i][j])
                else:
                    # ele=heapq.heappop(h)
                    if (-1*matrix[i][j])>h[0]:
                        heapq.heappop(h)
                        heapq.heappush(h,-1*matrix[i][j])
                j=j+1
        return -1*heapq.heappop(h)



// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
used binary search to implement this.First we take element at [0][0] as the least element and element at [len(matrix)-1][len(matrix)-1] as the largest element .we take the mid of these two and search in the given matrix for the count of elements less than given k.If it is less then we move our low pointer to second half else we move the high pointer to the first half.when it is equal to the count then we return the low value.

# using binary search
# Time complexity: o(mnlogn)
# space complexity :o(1)
class Solution(object):
    def getcount(self,matrix,mid):
        count=0
        for i in range(len(matrix)):
            j=len(matrix)-1
            while(j>=0 and matrix[i][j]>mid):
                j=j-1
            count=count+j+1
        return count
            
        
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        n=len(matrix)
        low=matrix[0][0]
        high=matrix[n-1][n-1]
        while(low<high):
            mid=low+int((high-low)/2)
            count=self.getcount(matrix,mid)
            print(mid,count)
            if count<k:
                low=mid+1
            else:
                high=mid
        return low
