# Time Complexity : O(min(n,k) + klog(min(n,k)))
# Space Complexity : O(min(n,k)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Maintain a min heap and insert first elements of each row in the heap
Then keep on popping the min until K elements popped
And while popping, push the next element in the row if there

"""

class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """

        n = len(matrix)
        minHeap = []
        for i in range(0,min(n,k)):
            minHeap.append((matrix[i][0],i, 0))

        heapq.heapify(minHeap)

        while k:
            element, r, c = heapq.heappop(minHeap)

            if c < n-1:
               heapq.heappush(minHeap,(matrix[r][c+1],r,c+1))

            k -= 1

        return element




