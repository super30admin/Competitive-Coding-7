Time Complexity - O(nklogk) where n is the total number of elements in the matrix
Space Complexity - O(k)
Ran successfully on leetcode

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        //base
        if(matrix.empty())
            return -1;
        priority_queue<int>pq;
        for(int i=0;i<matrix.size();i++)
            for(int j=0;j<matrix[0].size();j++)
            {
                pq.push(matrix[i][j]);
                if(pq.size()>k)
                    pq.pop();
            }
        return pq.top();
    }
};