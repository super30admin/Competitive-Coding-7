// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
// Time Complexity: O(k log n)
// Space Complexity: O(n)


class Solution {
    public:
        int kthSmallest(vector<vector<int>>& matrix, int k) {
            priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
            int n = matrix.size();
            for(int i=0; i<n; i++){
                pq.push({matrix[i][0], i, 0});
            }
            int val=0; 
            while(k--){
                auto top = pq.top();
                pq.pop();
                val = top[0];
                int row=top[1]; int col=top[2];
                if(col+1 < n){
                    pq.push({matrix[row][col+1], row, col+1});
                }
            }
            return val;
        }
    };