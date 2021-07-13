// Time Complexity : O(n log k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// K-th smallest element in a matrix

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int mid, count, temp;
        
        while (low < high) {
            mid = low + (high - low) / 2;
            temp = n - 1;
            count = 0;
            
            for (int i = 0; i < n; i++) {   // check number of elements smallert than mid and count
                while (temp >= 0 && matrix[i][temp] > mid) temp--;
                count += temp + 1;
            }
            
            if (count < k) low = mid + 1;
            else high = mid;
        }
        
        return low;
    }
};