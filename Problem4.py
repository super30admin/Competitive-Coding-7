#Time complexity is:O(nlog(hogh-low))
#Space complexity is:O(1)
#No issues faced while coding
#Code ran successfully on leetcode

#Finding kth largest element
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        #initializing all the required variables
        n=len(matrix)
        low=matrix[0][0]
        high=matrix[n-1][n-1]
        while(low<high):
            #Finding the mid value and finding the count of values less than mid value
            mid=low+(high-low)/2
            counter=self.count(matrix,mid)
            #if the counter is less than k we will make changes to low
            if(counter<k):
                low=mid+1
            #Otherwise we will make changes ti high
            else:
                high=mid
        #Finally we will return low
        return low

    #finding the count of values that are less than mid value in a row
    def count(self,matrix,mid):
        count=0
        length=len(matrix)
        #We will check last value in a row and we will make the decision based on that
        for i in range(length):
            j=length-1
            while(j>=0 and matrix[i][j]>mid):
                j-=1
            count+=j+1
        #Finally we are returning the count
        return count
