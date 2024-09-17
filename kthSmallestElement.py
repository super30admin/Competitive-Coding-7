'''
Time complexity --> O(nlogn)
Space Complexity --> O(1)
'''
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        def CountNumber(mid):
            count = 0
            j = len(matrix[0])-1
            for i in range(len(matrix)):
               
                while j>=0 and mid<(matrix[i][j]):
                    j-=1
                count+=j+1
            return count

        low = matrix[0][0]
        high = matrix[-1][-1]
        c = 0
        while low<high:
            #print(low)
            #print(high)
            mid = (low+high)//2
            #print(mid)
            c = CountNumber(mid)
            #print(c)
            if c<k:
                low = mid+1
            else:
                high = mid
        return low

        

