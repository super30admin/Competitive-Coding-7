#time : O(NlogN) where N = n^2
#space: O(N)
#brute force
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if(matrix==[]):
            return 0
        nums=[]
        for i in matrix:
            for j in i:
                nums.append(j)
        nums=sorted(nums)
        return nums[k-1]