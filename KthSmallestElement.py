#378. Kth Smallest Element in a Sorted Matrix
"""
Time Complexity : O(n logK)
Space Complexity : O(k)
"""
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        Maxheap =[]

        for rows in matrix:
            for num in rows:
                heapq.heappush(Maxheap,-num)
                if len(Maxheap)>k:
                    heapq.heappop(Maxheap)

        return -Maxheap[0] 
