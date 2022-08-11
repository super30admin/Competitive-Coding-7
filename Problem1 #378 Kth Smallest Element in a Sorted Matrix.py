# Time Complexity: nlog(k)
# Space Complexity: log(k)

# heappush = O(logN)
# heappop = O(logN)
# heapify = O(N)

import heapq as hp


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap_lst = []

        for rows in matrix:
            for row in rows:
                hp.heappush(heap_lst, -row)
                if len(heap_lst) > k:
                    hp.heappop(heap_lst)

        return -heap_lst[0]
