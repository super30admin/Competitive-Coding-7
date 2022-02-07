import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        # The size of the matrix
        N = len(matrix)
        
        # Preparing our min-heap
        minHeap = []
        for r in range(min(k, N)):
            
            # We add triplets of information for each cell
            minHeap.append((matrix[r][0], r, 0))
        
        # Heapify our list
        heapq.heapify(minHeap)    
        
        # Until we find k elements
        while k:
            
            # Extract-Min
            element, r, c = heapq.heappop(minHeap)
            
            # If we have any new elements in the current row, add them
            if c < N - 1:
                heapq.heappush(minHeap, (matrix[r][c+1], r, c+1))
            
            # Decrement k
            k -= 1
        
        return element  
            
'''
Algorithm :
Push the elements ( min of k and  length of col )
from the col 0 to the min heap. 

Run a while loop until k == 1:
	pop the an element from the min heap 
	check if there are any more elements in the same row,
	if yes, push that to the min heap 
	decrement the k val after each iteration 
return the final element. 

Time Complexity = min(N, K) + K log ( min(K , N) ) 
min(N, K)  - to push the min(N, K)  into the heap 
K log ( min(K , N) ) - in the while loop, we heapify log ( min(K , N) )  times
'''
