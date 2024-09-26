# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Time = O(k * log n) and worst case = O(n^2 logK) | space = O(n), maximum k elements will be in the heap.
import heapq
class Solution:
    def kthSmallest(self, matrix, k):
        if len(matrix) == 0:
            return -1
        st = [(matrix[indx][0], indx, 0) for indx, row in enumerate(matrix)] # 0 is the column 
        
        res = 0 
        
        for _ in range(k):
            res, row, col = heapq.heappop(st)
            if col + 1 < len(matrix[0]):
                heapq.heappush(st, (matrix[row][col+1], row, col+1))
        
        return res

if __name__ == "__main__":
    s = Solution()
    matrix = [
    [ 1,  5,  9],
    [10, 11, 13],
    [12, 13, 15]
    ]
    k = 8
    res = s.kthSmallest(matrix, k)
    print(res)
    