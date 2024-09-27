"""
FAANMG Problem #96 {Medium} 

378. Kth Smallest Element in a Sorted Matrix


Time Complexity O(klogk)
Space Complexity:  O(k)
        
Did this code successfully run on Leetcode : Yes

Heap Solution

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        n = len(matrix)

        # insert one row or one column into the heap
        minHeap = []
        for c in range(min(n,k)):
            heapq.heappush(minHeap, (matrix[0][c],0,c))

        # as soon as we remove the element from the heap, we insert one element from the popped row, but col + 1, we do this until k = 0
        # which gives us kth value
        while k:
            val, row, col = heapq.heappop(minHeap)
            if row < n - 1:
                heapq.heappush(minHeap, (matrix[row+1][col],row+1,col))
            k -= 1

        return val

"""
Heap Solution

Time Complexity O(klogk)
Space Complexity:  O(k)
# Leetcode : Solved and submitted
"""

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        n = len(matrix)

        # insert one row or one column into the heap
        minHeap = []
        for r in range(min(n,k)):
            heapq.heappush(minHeap, (matrix[r][0],r,0))

        # as soon as we remove the element from the heap, we insert one element from the popped row, but col + 1, we do this until k = 0
        # which gives us kth value
        while k:
            val, row, col = heapq.heappop(minHeap)
            if col < n - 1:
                heapq.heappush(minHeap, (matrix[row][col+1],row,col+1))
            k -= 1

        return val
"""
Heap Solution

Time Complexity O(klogk)
Space Complexity:  O(k)
# Leetcode : Solved and submitted
"""


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        
        # cell (value, row, column)
        min_heap = [(matrix[0][0], 0, 0)]
        visited = set([0,0])
        
        
        kSmallest = None
        directions = [[1, 0], [0, 1]]
        
        for i in range(k):
            kSmallest, row, col = heapq.heappop(min_heap)
            for dx,dy in directions: 
                r = row + dx
                c = col + dy 
                if r == n or c == n or (r,c) in visited:
                    continue
                
                heapq.heappush(min_heap, (matrix[r][c], r, c))
                visited.add((r,c))
            
        return kSmallest

    
"""
Binary Search Solution

# Time complexity : O(N log log(Max−Min))
# Space complexity : O(1)
# Leetcode : Solved and submitted
"""



class Solution:
    
    # This function traverses over the matrix and find the elements which are greater than the mid we just found, if that is k, then we have our element
    def helper(self, matrix, mid):
        count = 0
        for i in range(self.rows):
            j = self.cols - 1
            while j >= 0 and matrix[i][j] > mid:
                j -= 1
            count += j+1
        return count
    
    
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        self.rows = len(matrix)
        self.cols = len(matrix[0])

        # find rows and cols, high and low point in the matrix which is first and last element
        low = matrix[0][0]
        high = matrix[self.rows - 1][self.cols - 1]

        # we traverse until low and high cross each other
        while low <= high:
            mid = low + (high - low) // 2

            # after finding the mid element, it may or may not be present in the matrix
            curr = self.helper(matrix, mid)

            # if curr count is less than k, then we increment in the right half, else in the left one
            if curr < k:
                low = mid + 1
            else:
                high = mid -1
        # result would always be at low pointer
        return low

    


    