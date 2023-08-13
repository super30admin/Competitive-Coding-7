class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # Approach 1 Using MinHeap to fetch kth smallest element
        # Time O(n + klogn)
        # Space: O(n)
        # mheap = []
        # heapsize = (len(matrix) * len(matrix[0])) - k + 1
        # heapq.heapify(mheap)
        # for i in matrix:
        #     for j in i:
        #         if len(mheap) == heapsize:
        #             heapq.heappushpop(mheap, j)
        #         else:
        #             heapq.heappush(mheap,j)

        # return mheap[0]

        # Approach 2 Use sort approach
        # Time O(n + nlogn)
        # Space O(n)
        result = []
        for i in matrix:
            for j in i:
                result.append(j)

        result.sort()
        return result[k-1]


