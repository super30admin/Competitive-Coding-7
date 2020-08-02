import heapq
# APPROACH 1, MIN HEAP
# Time Complexity : O[(n^2)*log(n^2)], where n is the length and width of the given matrix
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

# This approach uses a Min Heap to sort all elements in ascending
# order, The heap is then popped K times to obtain the result
class Solution(object):
    def kthSmallestMinHeap(self, matrix, k):
        pq = []
        n = range(len(matrix))
        # Pushing all elems in matrix to heap
        for i in n:
            for j in n:
                heapq.heappush(pq, matrix[i][j])
        # Popping k - 1 times
        while k != 1:
            heapq.heappop(pq)
            k -= 1
        # Kth smallest elem
        return heapq.heappop(pq)

#--------------------------------------------------------x-------------------------------------------------------------#

# APPROACH 2, MAX HEAP
# Time Complexity : O[(n^2)*log(k)], where n is the length and width of the given matrix
# Space Complexity : O(k), where k is given as the input.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

# This approach uses a Max Heap, where only K elements are allowed
# in the heap, The heap is then popped once to obtain the result!
    def kthSmallestMaxHeap(self, matrix, k):
        pq = []
        n = range(len(matrix))

        for i in n:
            for j in n:
                heapq.heappush(pq, -matrix[i][j])
                # allowing only k elems in heap
                if len(pq) > k:
                    heapq.heappop(pq)
        # Kth smallest elem
        return -heapq.heappop(pq)
