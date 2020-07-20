import heapq

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