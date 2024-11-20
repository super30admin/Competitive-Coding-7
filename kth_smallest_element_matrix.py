# Time - O(NlogN + KlogK) 
    # Heap creation with rows added (N number of rows) and adding and popping values from heap
# Space - O(K) - space occupied by heap

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        if matrix is None or len(matrix) == 0:
            return -1
         
        heap = []
        
        rows, cols = len(matrix), len(matrix[0])
        
        for i in range(rows):
            # maintain a triplet tuple so we keep track of what row, col value we need to explore if we pop the minimum val

            heapq.heappush(heap, (matrix[i][0], i, 0))
            
        
        while k:

            element, i, j = heapq.heappop(heap) # since elements are all sorted, we are popping off the 1st min, 2nd and so on ...
            new_element_row = i
            new_element_col = j + 1 
            if new_element_row < rows and  new_element_col < cols:
                heapq.heappush(heap, (matrix[new_element_row][new_element_col], new_element_row, new_element_col))
                
            k -= 1 # since we popped one minimum, always dec the count
        return element # at end of while loop, the kth smallest is what is left
