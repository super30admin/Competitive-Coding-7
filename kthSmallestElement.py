# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First we count the frequency of elements in the smaller array using a map.
# Then for each element in the larger array, we check if it exists in the map and collect it.
# We remove it from the map when its frequency becomes zero and finally return the result.

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        rows, cols = len(matrix), len(matrix[0])
        low, high = matrix[0][0], matrix[rows-1][cols-1]
        
        while low <= high:
            mid = low + (high - low) // 2
            count = 0

            i, j = rows - 1, 0
            while i >= 0 and j < cols:
                if matrix[i][j] <= mid:
                    count += i + 1
                    j += 1
                else:
                    i -= 1

            if count < k:
                low = mid + 1
            else:
                high = mid - 1

        return low

                    


        