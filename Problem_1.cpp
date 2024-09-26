/**
 * Time Complexity:
 * O(Nlog(maxNumber - minNumber)) where N is tht total number of the elements in the matrix.
 * 
 */

/**
 * Space Complexity:
 * The space complexity is O(1) as we are not creating any extra space.
 * 
 */


/**
 * Approach:
 * There are many approaches for this solution. We cna go for brute force and heap based solutions
 * But they are not the most optimized solutions. So we opt for binary search. In binary search,
 * we set the left as the firs element of the matriz and right as the last element of the
 * matrix. Then we find mid, we use this mid to scan the entire matrix and reduce the search
 * space. It is not necessary the mid value is in the matrix so we look for the value
 * which is lesser than it. Now, we start compoaring the values in the matrix with the mid
 * starting from the top right column. Until the matrix values are gretaer than the mid,
 * we keep on moving to the left side in each row. And when this condition is not true,
 * we add the number of columns skipped to the count. This count is now compared with the
 * kth value. According to the comparison we reduce the search space.
 * 
 */




class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        
        int n = matrix.size();
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int ans = 0;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(helper(matrix, mid) >= k){
                ans = mid;
                right = mid-1;
            } else {
                left = mid +1;
            }
        
        }
        return ans;
    }
    
    
    private:
    int helper(vector<vector<int>>& matrix, int mid){
        int count = 0;
        int c = matrix.size() -1;
        
        for(int r = 0; r < matrix.size(); r++){
            while(c >= 0 && matrix[r][c] > mid) c--;
            count += c +1;
        }
        
        return count;
    }
};