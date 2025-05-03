# 526. Beautiful Arrangement

# TC : O(k), where k is the number of valid arrangements
    # In the worst case, this is bounded by O(N!), but in practice it's much better
    # The pruning based on divisibility conditions significantly reduces the search space
# SC : O(N)
    # The recursion stack can go up to depth N
    # The visited set stores at most N elements

# Did this code successfully run on Leetcode : Yes

# Approach :
# Problem Interpretation:
    # We need to count permutations of numbers 1 to N
    # For each position i, either:
        # The number at position i is divisible by i, OR
        # i is divisible by the number at position i
# Backtracking Approach:
    # We build arrangements position by position
    # For each position, we try all unused numbers
    # We only proceed if the divisibility conditions are met
    # This naturally prunes many invalid paths early
# Implementation Details:
    # We use a set to track used numbers for O(1) lookups
    # The backtracking function returns the count of valid arrangements
    # When the position exceeds N, we've found a complete valid arrangement


class Solution:
    def countArrangement(self, n: int) -> int:
        # Track the numbers we've already used in our current permutation
        visited = set()
        
        # Recursive function to build permutations
        def backtrack(position):
            # Base case: if we've filled all positions, we found a valid arrangement
            if position > n:
                return 1
            
            # Counter for valid arrangements
            count = 0
            
            # Try placing each number from 1 to N at the current position
            for num in range(1, n + 1):
                # Skip if number already used
                if num in visited:
                    continue
                
                # Check the beautiful arrangement conditions
                # 1. The number at position i is divisible by i
                # 2. i is divisible by the number at position i
                if num % position == 0 or position % num == 0:
                    # Mark this number as used
                    visited.add(num)
                    
                    # Recursively build the rest of the arrangement
                    count += backtrack(position + 1)
                    
                    # Backtrack: remove the number to try other possibilities
                    visited.remove(num)
            
            return count
        
        # Start backtracking from the first position
        return backtrack(1)
        