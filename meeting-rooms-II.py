"""
Runtime Complexity:
O(n log n)- we sort 'n' elements to compute our solution and any sorting would take n logn. Once they are sorted we use two pointers, one at the start of start array and another at the start of start array. 
Whenever we find start is less than end we increment the count by 1 and move low pointer by 1. Whenever we find the meeting has ended then we decrement count by 1.
Once all the elements in start array has been processed then we have our result.
Space Complexity: O(n) - we use two arrays, start and end to compute our solution.
Yes, the code worked on leetcode.
Issues while coding - No
"""

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start = sorted([i[0] for i in intervals])
        end = sorted([i[1] for i in intervals])
        result, count = 0,0
        low,high = 0, 0
        n = len(intervals)
        while low< n:
            if start[low]<end[high]:
                count+=1
                low+=1
            else:
                count-=1
                high+=1
            result = max(result,count)
        return result