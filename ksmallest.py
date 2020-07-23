import heapq

# using heaps
# maintain a max heap. push the elements to a max heap. Maintain the length of the heap to K while pushing the elements.
# After the traversal ends, pop the topmost element from the heap and return it's value.
# since we are maintaining k elements in the heap. time to insert an element to the heap will be O(nlogk) and space will be O(k).
# O(nlogk) time | O(k) space
class Node:
    def __init__(self, val):
        self.val = val
    
    def __lt__(self, other):
        if other.val < self.val:
            return True
        return False
    

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        ksmallest=[]
        
        for row in matrix:
            for elem in row:
                if len(ksmallest)==k:
                    heapq.heappushpop(ksmallest, Node(elem))
                else:
                    heapq.heappush(ksmallest, Node(elem))
        
        return heapq.heappop(ksmallest).val
