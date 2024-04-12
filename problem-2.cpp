// t-c: Nlogk
// s-c: k
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int> pq;
        for(int i = 0; i < matrix.size(); i++)
        {
            for(int j = 0; j < matrix[0].size(); j++)
            {
                if(pq.size() == k)
                {
                    if(matrix[i][j] < pq.top())
                    {
                        pq.pop();
                        pq.push(matrix[i][j]);
                    }
                }
                else
                    pq.push(matrix[i][j]);
            }
        }
        return pq.top();
    }
};
