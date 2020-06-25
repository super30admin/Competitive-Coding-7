# Time Complexity : O(N!) where we have N number of combination where N is number of element
# Space Complexity : O(N) where we use visited array of size N

class Solution:
    def countArrangement(self, N: int) -> int:
        visited =set()
        count = 0
        def recursion(i):
            nonlocal count
            if len(visited)%i !=0 and i%len(visited):
                return
            if len(visited)==N:
                count+=1
                return
            
            for i in range(1,N+1):
                if i not in visited:
                    visited.add(i)
                    recursion(i)
                    visited.remove(i)
        recursion(1)
        return count