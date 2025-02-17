class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        # T: O(n log n), S: O(n)
        start = sorted([i[0] for i in intervals])
        end = sorted([i[1] for i in intervals])

        s, e = 0, 0
        cnt, res = 0, 0

        while s < len(start):
            if start[s] < end[e]:
                cnt += 1
                s += 1
            else:
                cnt -= 1
                e += 1
            res = max(res, cnt)

        return res
