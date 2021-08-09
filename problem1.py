import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        
        #min heap solution 
        #Time O(klog(min(n,k)))+O(nlogn/klogk)-the first min(n,k) heap creation
        #SPace o(k)
        heap=[]
        n=len(matrix)
        #First we will store min(n,k) rows in heap as if n>k then only k elements are needed at heap atmost, (rows and columns are sorted),only first column
        for i in range(min(n,k)):
            #we will store as minheap, by default in python
            heappush(heap,(matrix[i][0], i, 0))
        while(k>0):
            k-=1
            element, r,c=heappop(heap)
            if c<n-1:
                #push elements in same row next col as they are sorted 
                heappush(heap,(matrix[r][c+1], r, c+1))
        #after k pops we will have the correct element from heap
        return element
        
        
