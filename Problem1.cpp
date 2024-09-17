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

 * Solution 2: using max heap
 * Time complexity: O(log(n)) where n is row*col 
 * space complexity: O(n) where n is row*col
 */

class Solution {
public:
    /* Get total num of elements which are less than or equal to num in the array */
    /*
    * Approach in detail"
    * Using binary search, and taking the min and max element in the matrix, we do the following
    * 1. Get the middle element, try to find the total number of elements which are less than or equal to this number
    *   in the matrix using function count_elem_less_than_num. The advantage is : that kth smallest numb which we are 
     * trying to find is going to be at the point where we get the count from the function count_elem_less_than_num =
      * our target. 
    * If the total number of elements are more than what you searched for in matrix, it means you need to move your
    * search window to the left to accomodate less elements. so the new search will be : start remains the same.
    * end will change to mid. Here we are not changing to mid -1 because there can be a case where mid is the actual point
    * where we get our target count elements. 
    * If total number of elements is less than what you searched for in matrix, it means you need to increase your search window
     * to do that... change start to mid + 1 and end remains the same so that we can get a higher window to search for
     *
     * matrix = [
               [ 1,  5,  9],
               [10, 11, 13],
               [12, 13, 15]
            ],
            k = 8,
     *  .for eg :for first iteration : low = 1 high = 15  
     *   we get mid = 8,,, total 2 elements ie 1 and 5 are less than 8 which is not equal to 8 target. so we move 
     * low to mid + 1 ie 9 and high to 15 and continue.
     *
    */
    int count_elem_less_than_num(vector<vector<int>>& matrix, int num) {
        int count = 0;
        int row = 0, col = 0;
        int len = matrix.size();

        /* For each row, go in the end and then keep on coming backwards until you find a number less than equal to num */
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
        
        /* The fact that matrix is row and col wise sorted, you can take min and max as left most and right most corner
         * elements */
        /* assuming vector is never empty */
        return binary_search(matrix, matrix[0][0], matrix.back()[len - 1], k);            

    }
    /* using max heap */
    int kthSmallest_ver2(vector<vector<int>>& matrix, int k) {
        int min = 0;
        int len = matrix.size();
        
        priority_queue<int> max_heap;
        
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (max_heap.size() == k) {
                    if (matrix[row][col] < max_heap.top()) {
                        max_heap.pop();
                        max_heap.push(matrix[row][col]);                        
                    }
                } else {
                    max_heap.push(matrix[row][col]);
                }
            }
        }            
        return max_heap.top();
    }
};
/* Execute on leetcode platform */


