class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    int getCount(vector<vector<int>>& matrix, int target) {
        int length = matrix.size();
        int count = 0;
        int i = length - 1;
        int j = 0;

        while (i >= 0 && j < length) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count;
    }
};