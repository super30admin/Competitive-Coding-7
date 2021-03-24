# Created by Aashish Adhikari at 3:00 PM 3/20/2021

'''
Time Complexity:
O(r.c) + O( rc log (rc) ) ~  O( rc log (rc) )

Space Complexity:
O(rc)
'''

class Solution(object):



    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """

        all_1D = []
        for row in range(len(matrix)): # O(r)
            all_1D.extend(matrix[row]) # Assuming that extend does not cause memory of the list to run out, O(c)

        all_1D.sort() # O( rc log (rc) )

        return all_1D[k-1]

