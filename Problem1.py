#Time complexity is: O(n)
#Space complexity is: O(n)
#Code ran successfully on leetcode
#No issues faced while coding

#Daily temperatures
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        #Creating a result list with default values as 0's
        result=[0 for i in range(0,len(temperatures))]
        #Creating a stacl
        st=[]
        for i in range(0,len(temperatures)):
            #If the temp[i] is greater than value at top of stack, we pop that and and add i-popped value in result array for that index
            while(len(st) and temperatures[i]>temperatures[st[len(st)-1]]):
                popped=st.pop()
                result[popped]=i-popped
            #If the incoming temperature is less, we will just append that to the stack 
            st.append(i)
        #Finally we will be returning the result
        return result    