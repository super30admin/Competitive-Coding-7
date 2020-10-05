// Time Complexity : O(m*n*log(k)) for traversing throught the complete matrix and minheap
// Space Complexity : O(k) for the minheap created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
       priority_queue <int, vector<int>, greater<int> > myheap;
        int heap_size = (matrix[0].size()*matrix.size())-k+1;
        for(int i=0;i<matrix.size();++i)
        {
            for(int j=0;j<matrix[0].size();++j)
            {
                myheap.push(matrix[i][j]);
                if(myheap.size()>heap_size) myheap.pop();
            }
            
        }
        return myheap.top();
    }
    
};
