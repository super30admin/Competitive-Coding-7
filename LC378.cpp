
// Time complexity O(2logn)
// Space complexity O(1)
class Solution {
    int lessthanmid(vector<vector<int>>& matrix, int mid)
    {
        int n  = matrix.size();
        int count = 0;
        // start from top right;
        for (int i = 0; i < n; i++)
        {
            int j = n-1;
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            count += (j + 1);
        }
        return count;
    }
    
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            int count = lessthanmid(matrix, mid);
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
};
