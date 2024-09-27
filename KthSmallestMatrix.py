# Using heaps
# TC = K + NlogK build heap + evaluating n elements with heap size of k
# SC = K heapsize
# We need to be able to traverse across matrix from element to its immediate next in col as well as row. This is made possible by using heap. Here we can maintain heap of first row elements. Each time we pop- we append same column next row element to the heap. We repeat k times- kth popped value is the required solution. 
import heapq
class Solution:
    def kthSmallest(self, matrix, k):
        if not matrix: return -1
        
        pq = []
        m, n = len(matrix), len(matrix[0])
        for i in range(n):
            heapq.heappush(pq, (matrix[0][i], 0, i))
            
        while k > 0:
            v, r, c = heapq.heappop(pq)
            r += 1
            if r<m and c<n:
                heapq.heappush(pq, (matrix[r][c], r, c))
            k-= 1
        return v

# Binary search
# TC: Nlog(max-min-range)
# SC: O(1)
# Motive: Kth smallest element in the matrix has k elements less than of equal to it in the matrix
# Here we perform BS based range of min max values. We half the ranges until we reach [Target, Target] range. After each mid calculation, we traverse through matrix to find count of elements that are lesser than or equal to mid. 
class Solution:
    def kthSmallest(self, matrix, k):
        if not matrix: return -1
        m, n = len(matrix), len(matrix[0])
        low, high = matrix[0][0], matrix[m-1][n-1]
        while low <= high:
            mid = low + (high - low)//2
            count = self.helper(matrix, mid, m, n)
            if count < k:
                low = mid + 1
            else:
                high = mid - 1            
        return low
    
    def helper(self, matrix, mid, m, n):
        count = 0
        j = n-1
        for i in range(m):
            while j >= 0 and matrix[i][j] > mid:
                j-=1
            count += j + 1
        return count
