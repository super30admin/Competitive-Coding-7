#Time complexity is: O(n)
#Space complexity is: O(n)
#Code ran successfully on leetcode
#No issues faced while coding

#Next greater element
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n=len(nums)
        #We will be taking initial values as -1 in the result
        result=[-1 for i in range(0,n)]
        #Creating an empty stack
        st=[]
        #We will iterating through the given array in a circular fashion
        for i in range(2*n):
            #Based on the below condtion, we will be adding next greater elements for a particular value in the reuslt array
            while(len(st) and nums[i%n]>nums[st[len(st)-1]]):
                result[st.pop()]=nums[i%n]
            #We will make sure that value are inserted into the stack only in the first round
            if(i<n):
                st.append(i)
        #Finally we will returning the result
        return result