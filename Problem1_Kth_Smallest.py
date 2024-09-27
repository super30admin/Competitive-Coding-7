#Problem 2: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
#Test Cases passed on Leetcode 
#Time Complexity:    O(n.logn)
#Space Complexity:   O(1)
#Approach- low-0th element , high=last element, find mid ,perform Binary Search by computing number of elements less than mid, moving low and high
#pointers accordingly.
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        #Brute force Approach
            # new_lst=[]
            # for i in range(len(matrix)):
            #     for j in range(len(matrix[0])):
            #         new_lst.append(matrix[i][j])
            # print(new_lst)
            # new_lst.sort()
            # return new_lst[k-1]
        
        #Binary Search Approach
         #   initializations
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[n - 1][n - 1]

        #   binary search stops when low touches high
        while (low <high):
            mid = low + int( (high - low) / 2)
            count = self.find_count_less_elements(matrix, mid)
            if(count < k):
                low = mid + 1
            else:
                high = mid

        #   the low value will be the kth smallest element        
        return low
        
        
    #get count of elements lesser than given value in the matrix  
    def find_count_less_elements(self,matrix,mid):
        count = 0
        
        for i in range(len(matrix)):
            j = 0
            while (j<len(matrix[0]) and matrix[i][j] <= mid):
    
                j+=1
            count +=j
       
        return count  