# // Time Complexity : O(K+ nlogK) where k is the heap size
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix: return -1

        pq = []
        m = len(matrix)
        n = len(matrix[0])
        for i in range(n):
            heapq.heappush(pq, (matrix[0][i], 0, i))

        while k > 0:
            v, r, c = heapq.heappop(pq)
            r += 1
            if r < m and c < n:
                heapq.heappush(pq, (matrix[r][c], r, c))
            k -= 1
        return v