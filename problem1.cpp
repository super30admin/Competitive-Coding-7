
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Approach 1
// Time Complexity : O(log(hi-lo) * (m+n))
// Space Complexity : O(1)
// we do binary search on our answer range. for each mid ,we check the no. of elements lessorequal to mid value .
// Based on that count, we proceed in our approach.
// The count is performed using a linear traversal but using sorted property, so we traversed m+n only.

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int m = matrix.size();
        int lo = matrix[0][0];
        int hi = matrix[m-1][m-1];
        int ans = matrix[0][0];
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            int count = find(matrix,mid);
            if(count>=k)
            {
                ans = mid;
                hi = mid-1;
            }
            else
            {
                lo = mid+1;
            }
        }
        return ans;
    }
    int find(vector<vector<int>>& matrix, int target)
    {
        int m = matrix.size();
        int count = 0;
        int c = m-1;
        for(int r = 0; r<m;r++)
        {
            while(c>=0 && matrix[r][c]>target) c--;
            count+= c+1;
        }
        return count;
    }
};

// Approach 2
// Time Complexity : O(log(hi-lo) * log(hi-lo)) ==> O(log(hi-lo))
// Space Complexity : O(1)
//we do binary search on our answer range. for each mid ,we check the no. of elements less to mid value .
// Based on that count, we proceed in our approach.
// The count is performed using a lower_bound which uses binary search.

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        int ans = matrix[0][0];
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            int count = 0;
            for(int i = 0;i<n;i++)
            {
                count+= lower_bound(matrix[i].begin(),matrix[i].end(),mid) - matrix[i].begin();
            }
            if(count>=k)
            {
                hi = mid-1;  
            }
            else
            {
                ans = mid;
                lo = mid+1;
            }
        }
        return ans;
    }
};