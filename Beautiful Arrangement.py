# Time Complexity :  O(k) k = number of permutations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def countArrangement(self, n: int) -> int:
        visited = set()
        count = 0
        def helper(num):
            nonlocal count
            #base
            if len(visited)%num != 0 and num%len(visited) != 0:
                return
            if n == len(visited):
                count += 1
            #logic
            for i in range(1,n+1):
                if i not in visited:
                    visited.add(i)
                    helper(i)
                    visited.remove(i)
            
        helper(1)
        return count