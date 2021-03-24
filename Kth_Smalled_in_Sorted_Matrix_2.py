# Created by Aashish Adhikari at 4:37 PM 3/20/2021

'''
Time Complexity:
O(k . row . logk)

Space Complexity:
O(row) + O(k)
'''

class Solution(object):

    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """


        import heapq
        import sys

        if k > (len(matrix) * len(matrix[0])):
            return -1

        indices = [0 for idx in range(len(matrix))]

        k_val = 0

        min_heap = []

        while k_val < k: # O(k)

            min_val = sys.maxsize
            row_chosen = None

            for row in range(0, len(indices)): # O(row)

                col = indices[row]

                if col < len(matrix[0]) and min_val > matrix[row][col]:

                    row_chosen = row
                    min_val = matrix[row][col]

            heapq.heappush(min_heap, min_val)   # O(logk)

            indices[row_chosen] += 1

            k_val += 1

        return min_heap.pop()
