/* Problem Statement:

378. Kth Smallest Element in a Sorted Matrix
Medium

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

 * Solution 1 : Binary Search 
 * Time Complexity : O(nlogn) where n is total elements in matrix and for each mid value being calculated we are trying to find
     the number of elements in the matrix less than equal to the mid which can also take upto n computations.
 * Space complexity : O(1) excluding result array  

 * Solution 2: TODO : with heap
 */

class Solution {
public:
    /* Get total num of elements which are less than or equal to num in the array */
    int count_elem_less_than_num(vector<vector<int>>& matrix, int num) {
        int count = 0;
        int row = 0, col = 0;
        int len = matrix.size();

        for (row = 0; row < len; row++) {
            for (col = len - 1; col >= 0; col--) {
                if (matrix[row][col] <= num) {
                    break;
                }
            }
            count += (col + 1);
        }
        return count;
    }
    
    int binary_search(vector<vector<int>>& matrix, int low, int high, int target) {
        int mid = 0;
        int num_elem = 0;
        /* binary search : here low high values start with min and max value of the sorted matrix */
        while (low < high) {
            mid = (low + high) / 2;
            
            num_elem = count_elem_less_than_num(matrix, mid);
            if (num_elem >= target) {
                return binary_search(matrix, low, mid,target);
            } else {
                return binary_search(matrix, mid + 1, high,target);
            }
        }
        /* Got the target, return it */
        return low;
    }
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int min = 0;
        int len = matrix.size();
        
        /* assuming vector is never empty */
        return binary_search(matrix, matrix[0][0], matrix.back()[len - 1], k);            

    }
};
/* Execute on leetcode platform */


