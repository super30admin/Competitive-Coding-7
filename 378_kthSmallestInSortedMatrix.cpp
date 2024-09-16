// Time Complexity : O(N*MlogN) where N is total elements in matrix and M is the total element in a row.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        if(matrix.empty() || matrix.size() == 0)
            return 0;
        int n = matrix.size();
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low<high){
            int mid = low + (high-low) / 2;
            int counter = getCount(matrix, mid); //get the number of values less than or equal to mid
            if(counter<k)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
    
    int getCount(vector<vector<int>>& matrix, int mid){
        int count = 0;
        int j = matrix.size()-1;
        for(int i=0; i<matrix[0].size(); i++){
            while(j>=0 && matrix[i][j] > mid)
                j--;
            count+=j+1;
        }
        return count;
    }
};
