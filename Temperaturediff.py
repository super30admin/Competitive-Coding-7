# Time Complexity : O(N) for each operation.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use stack and push the index and pop every element less than prev element then append the index diff to res.

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res=[0]*len(temperatures)
        stk=[]
        for i in range(0, len(temperatures)):
            while stk and temperatures[stk[-1]] < temperatures[i]:
                ind = stk.pop()
                res[ind] =(i-ind)
            stk.append(i)
        return res