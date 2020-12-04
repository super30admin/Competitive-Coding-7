#Simple comaprisons to solve the problem
#Time complexity: O(nlogn)
#Space complexity: O(n)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals)==0:
            return 0
        if len(intervals)==1:
            return 1
        li = sorted(intervals)
        count = 0
        for i in range(len(intervals)):
            if i == 0:
                count += 1
            else:
                elem = li[i]
                prev = li[i-1]
                if (elem[0] >= prev[1]):
                    continue
                else:
                    count += 1
        return count