# Time Complexity : O(logn) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to do binary search for the index by finding mid that are even or odd then search for pairs.

class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        while(l<h):
            m=int(l+(h-l)/2)
            if(m%2==0):
                k=m+1
            else:
                k=m-1
            if(nums[k]==nums[m]):
                l=m+1
            
            else:
                h=m
        return nums[l]