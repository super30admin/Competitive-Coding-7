#brute force Solution
#time Comp- O(nlogn) Sorting array Not very sure correct if i am wrong
#space-O(n) extra space needed for array ans
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        #sort the intervals as per start time
        intervals=sorted(intervals,key = lambda x:x[0])
        ans=[]
        for i in range(0,len(intervals)):
            if ans!=[]:
                min_val=min(ans)
                min_index=ans.index(min_val)
            if ans==[]:
                ans.append(intervals[i][1])
            elif min_val>intervals[i][0]:
                ans.append(intervals[i][1])
            elif min_val <=intervals[i][0]:
                ans[min_index]=intervals[i][1]
        return len(ans)
        
        
