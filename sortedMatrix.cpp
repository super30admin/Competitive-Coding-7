// Time Complexity :O(n*logn)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int low  = matrix[0][0];
        int high = matrix[rows-1][cols-1];
        while(low <= high){
            int mid = low + (high-low)/2;
            int count=0;
            for(int i = 0; i < rows;i++){
                vector<int> vec = matrix[i];
                count += upper_bound(vec.begin(),vec.end(),mid) - vec.begin();
            }
            if(count < k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
};

/*Heap Solution - 
int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int> pq;
        for(int i = 0;i<matrix.size();i++){
            for(int j = 0;j<matrix[0].size();j++){
                pq.push(matrix[i][j]);
                if(pq.size() > k)
                    pq.pop();
            }
        }
        return pq.top();
    }
*/