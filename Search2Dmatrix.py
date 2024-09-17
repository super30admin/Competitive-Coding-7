# Time Complexity :if two arrays sorted average O(max(log(m),log(n)))
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    # normal binary search
    def binarysearch(self,array,target):
        low  = 0
        high = len(array)-1
        while low <= high:
            mid = low+(high-low)/2
            if array[mid] == target:
                return True
            elif array[mid] < target:
                low  = mid+1
            else:
                high = mid-1
        return False
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        # binary search on the rows
        low = 0
        high = len(matrix)-1
        while low <= high:
            mid = low + (high-low)/2
            # check that the number is in the range of the array of mid
            if matrix[mid][0] <= target and matrix[mid][-1] >= target:
                return self.binarysearch(matrix[mid],target)
            elif(matrix[mid][0] < target):
                
                low = mid + 1
            else:
                high = mid - 1
        return False