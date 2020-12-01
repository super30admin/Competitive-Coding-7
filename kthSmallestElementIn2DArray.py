#Time Complexity : O(min(n, k) + klog(n,k)) where n is the number of rows and k is the given input
#Space Complexity : O(min(n, k))
#Did this code successfully run on Leetcode : Yes

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        heap = []
        for r in range(min(k, len(matrix))):
            heap.heappush((matrix[r][0], r, 0))

        #Get k elements in heap
        while k:
            #get mim number in heap
            num, r, c = heapq.heappop(heap)
            #if there are any elements left in the current row, then append the next column element in the row
            if c < len(matrix) - 1:
                heapq.heappush(heap, (matrix[r][c+1], r, c+1))
            k -= 1

        return num
