# Time Complexity : Add - n^2 * logK
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use max heap of size K,
2. Push elements into max heap, and pop when elemnts exceed K
'''


from heapq import heappush as push
from heapq import heappop as pop

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if not matrix or len(matrix) < 1 or len(matrix[0]) < 1:
            return -1
        
        row = len(matrix)
        col = row
        
        heap_list = []
        for i in range(row):
            for j in range(col):
                push(heap_list, -matrix[i][j])
                
                if len(heap_list) > k:
                    pop(heap_list)
                    
        return -pop(heap_list)

#Solution 2
# Time Complexity : Add - K log N, Preferrable when N << K
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use min heap to push all elements in first columns
2. start popping elements and push next adjacent elment. Repeat K times
'''


from heapq import heappush as push
from heapq import heappop as pop

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if not matrix or len(matrix) < 1 or len(matrix[0]) < 1:
            return -1
        
        row = len(matrix)
        col = row
        
        heap_list = []
        for i in range(row):
            push(heap_list, (matrix[i][0], i, 0))
            
        # print (heap_list)
        while k > 1 and len(heap_list) > 0:
            
            min_val, x, y = pop(heap_list)
            if y+1 < col:
                push(heap_list, (matrix[x][y+1], x, y+1))
                
            k -= 1
            
        return pop(heap_list)[0]
                

                    
        