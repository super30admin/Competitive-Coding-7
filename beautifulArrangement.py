class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.backtrack(n, 1, [])
        return self.count
    
    def backtrack(self, n: int, index: int, path: List[int]) -> None:
        # base case
        if index > n:
            self.count += 1
            return
        
        # logic
        for i in range(1, n + 1):  # Iterate from 1 to n
            if i % index == 0 or index % i == 0:
                if i not in path:
                    path.append(i)
                    self.backtrack(n, index + 1, path)
                    path.pop()

