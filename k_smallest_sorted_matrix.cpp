// Time Complexity :O(mn log(mn-k))
// Space Complexity : O(mn-k);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//writing custom comparator was a bit difficult
//have to practice that.
// Your code here along with comments explaining your approach
//1. Add the last row with highes numbers in the priority queue
//2. Implement max heap and keep on removing the max element
//3. Maintain a minimum variable to hold the kth largest element
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int m = matrix.size();//row
        int n = matrix[0].size(); //col
        //edge case
        if(k>(m*n)) return INT_MIN;
        
        //logic
        auto comp = [&matrix](pair<int, int> a, pair<int, int> b){
            return matrix[a.first][a.second] < matrix[b.first][b.second];
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> max_pq(comp);
        for(int i=0;i<n; i++){
           max_pq.push({m-1,i}); 
        }
        
        int min= INT_MAX;

        int i=0;
        while(!max_pq.empty()){
            pair<int, int> matrix_idx = max_pq.top();
            max_pq.pop();
            int r = matrix_idx.first, c = matrix_idx.second;
            if(i<=(m*n-k)){
                if(min>matrix[r][c]) min = matrix[r][c];
                i++;
            }else if(i>(m*n-k)){
                break;
            }
            if(r-1>=0) max_pq.push({r-1,c});
            
        }
            return min;
    }
};
