// Time Complexity : O(mn)logk; m rows n cols 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Kth smallest element of n elements is same as largest of k smallest elements
// 2. Create a max-heap and add first k elements of matrix. Later add new elements only if its smaller than top of heap
// 3. Return top of heap as final result

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
       if(matrix.size()==0)
            return -1; 
       // largest of k smallest elements
        priority_queue<int> pq;
        for(int i=0; i<matrix.size(); i++){
            for(int j=0; j<matrix[0].size(); j++){
                if(pq.size() < k)
                    pq.push(matrix[i][j]);
                else if(matrix[i][j] < pq.top()){
                    pq.pop();
                    pq.push(matrix[i][j]);
                }
            }
        }
        return pq.pop();
    }
};