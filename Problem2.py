'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach
Add all the elements into min/maxheap and pop them 'k' or 'n-k+1' times to get the smallest 'kth' element

'''

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        maxheap = []
        res = None

        for r in matrix:
            for e in r:
                heapq.heappush(maxheap,-e)

        for _ in range(len(maxheap)-k+1):
            res = heapq.heappop(maxheap)

        return -res