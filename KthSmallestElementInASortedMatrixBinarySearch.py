'''
TC: O((log(m*n)) * (mlogn)) - binary search inside binary search
                        m - number of rows, n is cols
SC: O(1) - no explicit space required since we are using some pointers
'''
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        
        def countElements(row, num):
            l,r = 0,len(row)-1
            while l<=r:
                mid = (l+r)//2
                if row[mid]<=num:
                    l = mid+1
                else:
                    r = mid-1
            return l       

        l,r = matrix[0][0], matrix[ROWS-1][COLS-1]
        while l<r:
            mid = (l+r)//2
            total = 0
            for row in matrix:
                v = countElements(row, mid)
                total += v
            if total<k:
                l = mid+1
            else:
                r = mid
        return l