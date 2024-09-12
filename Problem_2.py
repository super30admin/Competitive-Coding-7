# 378. Kth Smallest Element in a Sorted Matrix

# Code:

import heapq

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # Brute force: Convert to 1-D Array sort and get the k-1 element !
        
        '''
        res = []
        
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                res.append(matrix[i][j])
        
        res.sort()
        
        return res[k-1]
        '''
        
        
        # Optimized space by using HEAPS.
        '''
        res = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(res, matrix[i][j])
        
        for i in range(k-1):
            heapq.heappop(res)
        
        return heapq.heappop(res)
        '''
        
        #Optimizing time using Binary search.
        
        low = matrix[0][0]
        high = matrix[-1][-1]
        
        while low<high:
            mid = (low+high)//2
            
            temp = self.helper(matrix, mid)
            if temp<k:
                low=mid+1
            else:
                high = mid
        
        return low
    
    def helper(self, matrix, mid):
        count = 0
        
        for i in range(len(matrix)):
            j=0
            
            while j<len(matrix) and matrix[i][j]<=mid:
                j+=1
            count+=j
            
        return count
        

# Time complexity = O(logN)
# Space complexity = O(1)
# Accepted on Leetcode = YES
