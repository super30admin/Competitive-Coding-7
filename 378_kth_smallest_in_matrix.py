# Leetcode problem link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
# Time Complexity:    O(klogN) for heaps and NlogN for binary search
# Space Complexity:   O(N) for heaps and O(1) for binary search
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Heaps:  Insert the 0th column values for all the rows in a heap.
                Iterate k times and pop element from heap. If the popped element has a next valid column value, push it to heap. Decrement k
                Return the response after k becomes 0 as the popped element will be kth smallest
                
        Binary Search: Start with 0th element as low and last element as high, compute mid from these two values,
    perform Binary Search by computing number of elements less than mid, moving low and high
    pointers accordingly.
'''
from heapq import heappush as insert
from heapq import heappop as remove
class Node:
    def __init__(self,val,row,col):
        self.val = val
        self.row = row
        self.col = col
    def __lt__(self,other):
        return self.val < other.val
class Solution:
    def kthSmallest_heap(self, matrix: List[List[int]], k: int) -> int:
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        
        min_heap = []
        
        n = len(matrix)
        m = len(matrix[0])
        
        for i in range(n):
            insert(min_heap,Node(matrix[i][0],i,0))
        
        current = None
        while k >0:
            current = remove(min_heap)
            
            if current.col+1 < m:
                insert(min_heap,Node(matrix[current.row][current.col+1],current.row,current.col+1))
            k -= 1
        return current.val
    
    
    def __getCount(self, matrix: List[List[int]], mid: int) -> int:

        #   function to get count of elements lesser than given value in the matrix.
        #   Takes O(n) time where matrix size is nxn
        
        count = 0
        j = len(matrix) - 1
        
        #   keep checking the last col's value in a row and decrement col only if value is lesser than mid
        #   else add those many elements till col in that row to the count
        for i in range(len(matrix)):
            while (j >= 0 and matrix[i][j] > mid):
                j -= 1
            count += (j+1)
        
        #   return final count  
        return count
    
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        

        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n - 1][n - 1]
        
        #   binary search stops when low is equal to high
        while (low < high):
            mid = low + int( (high - low) / 2)
            count = self.__getCount(matrix, mid)
            
            if(count < k):
                low = mid + 1
            else:
                high = mid
        
        #   the low value will be the kth smallest element        
        return low