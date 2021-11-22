"""
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
"""
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        array = []
        for i in range(len(matrix)):  ##nsquare
            for j in range(len(matrix[0])):
                array.append(matrix[i][j])

        ##sort
        array.sort()  ##nlogn
        print(array)

        return array[k - 1]

    ##need to optimize for bst


