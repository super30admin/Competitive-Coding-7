# Time Complexity :
# O(NM log k)

# Space Complexity :
# O(k)

# Did this code successfully run on Leetcode :
#Yes

#We add all the elements into a max heap of size k. When the size of the heap is greater than k, we remove the maximum element, and at the end of this, we are left with k smallest elements in the max heap. Then we just pop the top element from the heap and that is the kth smallest element. 
#In this code, we use a min heap with negated input values to simulate a max heap

from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        self.heap = []
        curr_size = 0
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                insert(self.heap, -1 * matrix[i][j])
                curr_size += 1
                if curr_size > k :
                    remove(self.heap)
        return -1 * remove(self.heap)
