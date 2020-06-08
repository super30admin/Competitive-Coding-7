#Time Complexity: O((n*m)log(m))) , m number of rows, n number of columns
#Space Complexity : O(m)

'''
Similarly to the merging arrays problem, we create a heap with the first elements with their indices.
we pop and move until we've poped k element.
'''

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return None
        heap=[]
        for l in matrix:
            if l:
                heapq.heappush(heap,(l[0],0,l))
        count=0
        prev=None
        while count<k:
            count+=1
            el,i,l=heapq.heappop(heap)
            if i<len(l)-1:
                heapq.heappush(heap,(l[i+1],i+1,l))

        return el
            
