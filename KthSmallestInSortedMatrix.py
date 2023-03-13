#All TC passed on leetcode

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        #Here we perform binary search on nums b/w smallest and largest num of matrix. 
        #Then we count the nums in matrix that are lesser than mid, if count is greater than k then we 
        #shift our search space to left else we shift our search space to right.
        #Time complexity - O(n.logH) where n - number of rows, and H is the numbers b/w lowest and highest number in the matrix 
        #Space complexity - O(1)
        n = len(matrix)
        # Set the range of the search to be between the smallest element
        # and the largest element in the matrix
        left, right = matrix[0][0], matrix[n - 1][n - 1]

        # Binary search for the kth smallest element
        while left <= right:
            mid = (left + right) // 2
            count = 0
            j = n - 1
            # Count the number of elements in the matrix that are less than or equal to mid
            for i in range(n):
                while j >= 0 and matrix[i][j] > mid:
                    j -= 1
                count += j + 1
            # Update the range of the search
           
            if count < k:
                left = mid + 1
            else:
                right = mid - 1

        return left

#--------------------------------------OR----------------------------------------------
        
        #Time complexity - O(X + KlogX) where X = min(k, rows)
        #Space complexity - O(X) - heap size
        minHeap = []
        rows = len(matrix)
        cols = len(matrix[0])
        
        for r in range(min(k,rows)):
            minHeap.append([matrix[r][0], r, 0])
            
        heapq.heapify(minHeap)
        
        while k:
            k-=1
            val, r, c = heapq.heappop(minHeap)
            if k==0:
                return val
            if c+1 < cols:
                heapq.heappush(minHeap, [matrix[r][c+1], r, c+1])
            
        
        