# Time complexity: O(klogn) as we are pushing only k items into the heap not more.
# Space complexity: O(k) as thats the heap size

# The intuition is simple, we only push highest elements in each row into the heap. Then check if next element in each row exists then insert that only until k elements
# Once all the iterations are done then return the top elements as that will be kth smallest

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        minHeap = []
        for i in range(min(k, n)):
            heapq.heappush(minHeap, (matrix[i][0], i, 0))

        while k > 1:
            val , r , c = heapq.heappop(minHeap)
            if c + 1 < len(matrix[0]):
                heapq.heappush(minHeap, (matrix[r][c+1], r, c+1))
            k -= 1

        return minHeap[0][0]