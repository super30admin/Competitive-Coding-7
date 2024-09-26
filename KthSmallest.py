'''
Solution:
1.  The problem can be solved using Heaps or using Binary Search.
2.  Place all elements from the first column (n) inside a min heap, pick the minimum of the heap
    and move forward in the row containing min element. Repeat the process k times to get kth
    smallest element.
3.  Start with 0th element as low and last element as high, compute mid from these two values,
    perform Binary Search by computing number of elements less than mid, moving low and high
    pointers accordingly.

Time Complexity:    O(N*log(N^2)) = O(N*2logN) ~ O(NlogN) for Binary Search
                    O(k*logN) when using Heaps
Space Complexity:   O(1) for Binary Search
                    O(N) when using Heaps
                    where matrix size is NxN

--- Passed all testcases successfully on Leetcode for both the solutions.
'''


from heapq import heappush as push
from heapq import heappop as pop

class ValueCell:
    
    #   store cell's value and corresponding row and column
    def __init__(self, value, row, col):
        self.val = value
        self.row = row
        self.col = col
    
    #   operator overloading    
    def __lt__(self, x):
        return self.val < x.val
    
    def __gt__(x, y):
        return x.val > y.val

class KthSmallestHeap:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        #   edge case check
        if (matrix == None or len(matrix) == 0):
            return -1
        
        #   initializations
        nRows = len(matrix); nCols = len(matrix[0])
        kSmall = []
        
        #   first column elements inside the minHeap
        for r in range(nRows):
            currObj = ValueCell(matrix[r][0], r, 0)
            push(kSmall, currObj)
           
        currObj = None
        
        #   remove min from heap k times and insert next min element k times
        for i in range(k):
            currObj = pop(kSmall)                                       #   remove min element
            row = currObj.nRows                                         #   extract row and col of extracted min element
            col = currObj.col
            
            if (col + 1 < nCols):                                       #   if next col is valid => push next col's value
                nextObj = ValueCell(matrix[row][col + 1], row, col+1)
                push(kSmall, nextObj)
            
            else:                                                       #   else min heap's size is reduced by one
                pass
            
        return currObj.val                                              #   return kth min object's value

class KthSmallestBinSearch:
    
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
        
        #   initializations
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n - 1][n - 1]
        
        #   binary search stops when low touches high
        while (low < high):
            mid = low + int( (high - low) / 2)
            count = self.__getCount(matrix, mid)
            
            if(count < k):
                low = mid + 1
            else:
                high = mid
        
        #   the low value will be the kth smallest element        
        return low
        