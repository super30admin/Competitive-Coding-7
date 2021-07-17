// Time Complexity : O(n*n)
// Space Complexity :  O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Can be better with Binary Search

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {

        // Heap implementation for getting k smallest elements        
        priority_queue<int> pq;
        
        int n = matrix.size();
        
        // Traverse through all elements in the matrix
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // Push in heap
                pq.push(matrix[i][j]);
                
                // Pop largest element if size greater than k
                if(pq.size() > k)
                    pq.pop();
            }
        }
        
        return pq.top();
    }
};