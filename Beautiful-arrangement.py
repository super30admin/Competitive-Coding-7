# Tc - O(n!)
# SC - O(n)
class Solution:
    # count = 0
    # visited = set()
    def countArrangement(self, n: int) -> int:
        self.count = 0  # Reset count
        self.visited = set()  # Use set for fast lookup
        self.N = n  # Store N for later use
        self.recursion(1)  # Start recursion with index 1
        return self.count  # Return the total count of valid arrangements

    def recursion(self,i):
        ## Base condition
        if len(self.visited) > 0 and i%len(self.visited)!=0 and len(self.visited)%i!=0:
            return
        if len(self.visited) == self.N:
            self.count+=1
            return    

        ## Logic
        for i in range(1,self.N+1):
            if i not in self.visited:
                self.visited.add(i)
                self.recursion(i)
                self.visited.remove(i)        

     
        

     
