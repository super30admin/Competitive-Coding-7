# Time Complexity : O(n*n log k) [n = row and col size of matrix]
# Space Complexity : O(k) [k = size of max heap]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem approach
# 1. Traverse the matrix row wise and push values in max heap
# 2. If the size of the heap exceeds k during traversal, then perform pop operation
# 3. After travesal, the element at top of heap is the desired answer
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:return 0
        
        max_heap = []
        
        for i, row in enumerate(matrix):
            for j, col in enumerate(row):
                heappush(max_heap, -1 * col) # multiply with -1 to covert min heap to max heap
                if len(max_heap) > k:
                    heappop(max_heap)
        return -1 * max_heap[0]