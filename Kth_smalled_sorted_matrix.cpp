// Kth Smallest Element in a Sorted Matrix
// Time Complexity: O(n log(max-min)), where n is the number of elements in the matrix.
// Space Complexity: O(1)
// Did the code run successfully on LeetCode? Yes

// Approach:
// 1. Use binary search to find the kth smallest element.
// 2. The range of the search is from the smallest element to the largest element in the matrix.
// 3. For each mid value, count how many elements are less than or equal to mid.


#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int row = matrix.size();
        int col = matrix[0].size();
        int low = matrix[0][0];
        int high = matrix[row - 1][col - 1];

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(count(mid, row, col, matrix, k) < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
private: 
    //Function that counts how many values exist before a mid
    int count(int mid, int row, int col, vector<vector<int>>& matrix, int k){
        int count = 0; 
        row = matrix.size() - 1;
        col = 0;
        while(row >= 0 && col < matrix.size()){
            if(matrix[row][col] <= mid){
                count += row + 1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
};