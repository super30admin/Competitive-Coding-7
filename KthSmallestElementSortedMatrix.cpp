/*
Intuition: The idea here is to apply binary search to get a mid value. We can then count the number elements 
upto that mid value and increase the low or high accordingly.

Time Complexity: O((N×log(Max−Min)))
Space Complexity: O(1)

*/
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while ( low < high){
        
            int mid = ( low) + ( high - low)/2;
            int count = getCount(matrix, mid);
            if ( count < k) low = mid+1;
            else high = mid;
        
        }
        return low;
    }
    int getCount(vector<vector<int>>& matrix,int mid){
        int count = 0;
        int j = matrix.size()-1;
        for ( int i = 0;  i < matrix.size(); i++){
            while ( j>=0 and matrix[i][j] > mid ) j--;
            count+=j +1;
        }
        
        
        return count;
    }
};