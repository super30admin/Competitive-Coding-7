# APPROACH 1: BRUTE FORCE
# Time Complexity : O(n^2 + n^2 lg n^2), n: number of rows (or columns) of the matrix
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Flatten the matrix
# 2. Sort it in ascending order
# 3. Take the element at k - 1 as the result

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if matrix is None:
            return None
        
        flat_list = []
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                flat_list.append(matrix[row][col])
                
        flat_list.sort()
        
        return flat_list[k - 1]
        
        

# APPROACH 2: INTERMEDIATE SOLUTION
# Time Complexity : O(n^2 lg k), n: number of rows (or columns) of the matrix, k: given 
# Space Complexity : O(k), size of max_heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Go through each element of the matrix
# 2. Push to max_heap. If size of max_heap exceeds k, then pop (discarding n^2 - k max elements)
# 3. At the end, the element at the root is the result as heap now stores only the k smallest elments.

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if matrix is None:
            return None
        
        max_heap = []
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                heapq.heappush(max_heap, -1 * matrix[row][col])
                
                if len(max_heap) > k:
                    heapq.heappop(max_heap)
                    
        return -1 * max_heap[0]
        
        

# APPROACH 3: OPTIMAL SOLUTION 1 : MIN HEAP OF SIZE n
# Time Complexity : O(n^2 lg n), n: number of rows (or columns) of the matrix
# Space Complexity : O(n), size of min_heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. have min heap of size n. Initially, push only the elements of the first column (along with their row, column)
# 2. Do this k times, keep popping and store the next element in that same row of the popped element (it's right neighbor)
# 3. At end, the element that was just last popped is the answer. (min heap kept popping k times so k smallest elements were discarded).

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if matrix is None:
            return None
        
        min_heap, count_min_pop = [], 0
        for row in range(len(matrix)):
            heapq.heappush(min_heap, (matrix[row][0], row, 0))
            
        while min_heap and count_min_pop < k:
            element, row, col = heapq.heappop(min_heap)
            if col + 1 < len(matrix[0]):
                heapq.heappush(min_heap, (matrix[row][col + 1], row, col + 1))
            count_min_pop += 1
            
        return element
        
        

# APPROACH  4: OPTIMAL SOLUTION 1 - MAX HEAP OF SIZE n
# Time Complexity : O(n^2 lg n), n: number of rows (or columns) of the matrix
# Space Complexity : O(n), size of max heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as the above approach 3. 
# 2. Instead using max heap. so k th smallest from start is (n^2 - k + 1)th largest element from end.
# 3. Keep repeating the popping procedure till (n^2 - k + times. 1) times.

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if matrix is None:
            return None
        
        max_heap, count_max_pop = [], 0
        for row in range(len(matrix)):
            heapq.heappush(max_heap, (-1 * matrix[row][-1], row, len(matrix[0]) - 1))
            
        while max_heap and count_max_pop < (len(matrix) * len(matrix[0]) - k + 1):
            element, row, col = heapq.heappop(max_heap)
            if col - 1 >= 0:
                heapq.heappush(max_heap, (-1 * matrix[row][col - 1], row, col - 1))
            count_max_pop += 1
            
        return -1 * element
        



# APPROACH  5 : OPTIMAL APPROACH: BINARY SEARCH
# Time Complexity : O(n^2 lg (max - min)), n: number of rows (or columns) of the matrix, max: maximum number in matrix and min: minimum number in matrix
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. We do binary search for the number range instead of index range. Begin with start -> min element of matrix and end -> max element of matrix
# 2. Each time count number of elements that are less than mid element(since we need to find the smallest element), find the element thats just less than and greater than mid. 
#     Count in intelligent way. start with last row. If any cell value is less than mid, then all values in that column is also less than mid so add to count and move right. 
#     if the cell value is greater than mid, then move upwards till you find lesser value than mid or first row. 
# 3. If the size of left half == k -> then result is the element just before mid (in value)
#                              > k -> the mid here is of no use to us as the k is less than number of elements less than half. so have to search in left. shift end to element 
#                                     just less than mid in value. 
#                              < k -> the mid here is of no use to us as k is more than the number of elements less than mid. so we have to search right of mid. shift start to
#                                     element that's just larger than mid

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if matrix is None:
            return None
        
        start, end, min_elem, max_elem = matrix[0][0], matrix[-1][-1], matrix[0][0], matrix[-1][-1]
        
        while start < end:
            mid = start + (end - start) // 2
            count_left_half, just_small_mid, just_large_mid = self.count_left(matrix, mid, min_elem, max_elem)
            
            if count_left_half == k:
                return just_small_mid
            
            elif count_left_half < k:
                start = just_large_mid
                
            else:
                end = just_small_mid
                
        return start
            
            
    def count_left(self, matrix, mid, just_small_mid, just_large_mid):
        row, col, count = len(matrix) - 1, 0, 0
        
        while row >= 0 and col < len(matrix[0]):
            if matrix[row][col] <= mid:
                count += (row + 1)
                just_small_mid = max(just_small_mid, matrix[row][col])
                col += 1
                
            elif matrix[row][col] > mid:
                just_large_mid = min(just_large_mid, matrix[row][col])
                row -= 1
                
        return count, just_small_mid, just_large_mid
              
