# Time Complexity: O(nlog(n))
# Space Complexity: O(n)
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """

        start= sorted([i[0] for i in intervals])
        print(start)
        end = sorted([i[1] for i in intervals])
        print(end)
        s=0
        e=0
        count =0
        ans=0

        while (s<len(intervals)):
            if start[s] <end[e]:
                count +=1
                s+=1
            else:
                count-=1
                e+=1
            ans = max(ans,count)
        return(ans)
