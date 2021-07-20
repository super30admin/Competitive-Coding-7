"""
Approach: using min heap
This approach is similar to that of merging sorted linked lists. You get the least of the nodes in the current position and add the next node to your heap.

1) get all the first elements of each row into the min heap
    a) Note that the columns are also in the sorted manner, so in the worst case the first element of  the last row might be less than the second element of the first row

    b) Also, we do not need to get elements of all rows since we are look for kth largest elements

2) pop the node and add the next element to the heap. This way, you discard the first k small elements


TC: O(min(m,k) + k log (min(m,k)))
SC: O(min(m,k))
"""

import heapq as q


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        pri_q = []
        m = len(matrix)
        n = len(matrix[0])
        for r in range(min(m, k)):
            q.heappush(pri_q, (matrix[r][0], r, 0))
        q.heapify(pri_q)
        print(pri_q)
        while k:
            curr, curr_r, curr_c = q.heappop(pri_q)
            if curr_c < n - 1:
                q.heappush(pri_q, (matrix[curr_r][curr_c + 1], curr_r, curr_c + 1))
            k -= 1
        return curr