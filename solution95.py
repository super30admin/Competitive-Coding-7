#Time ComplexityO(mn)
#Space Complexity:O(mn)
import queue as Q
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        q=Q.PriorityQueue()
        count=k
        for row in matrix:                      #Add each element into priority queue
            for n in row:
                q.put(n)
        while(count!=1):                        #pop first k-1 elements
            q.get()                             
            count-=1
        return q.get()                          #return the kth element