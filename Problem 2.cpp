//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    void update_visited(vector<vector<int>>& matrix, vector<vector<bool>> &visited){
        for(int i=0; i<matrix.size(); i++){
            vector<bool> temp;
            for(int j=0; j<matrix[0].size(); j++){
                temp.push_back(false);
            }
            visited.push_back(temp);
        }
    }
    
    //priority queue + BFS solution
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        vector<vector<bool>> visited;
        update_visited(matrix, visited);
        
        int n = matrix.size();
        
        vector<int> fir;
        fir.push_back(matrix[0][0]); fir.push_back(0); fir.push_back(0);
        pq.push(fir);
        visited[0][0] = true;
        
        int dirs[2][2] ={ {1,0},{0,1}};
        int last_popped = matrix[0][0];
        
        while(k>0){
            vector<int> temp = pq.top(); pq.pop();k--;
            last_popped=temp[0];
            
            for(int i=0; i<2; i++){
                int r = dirs[i][0]+temp[1];
                int c = dirs[i][1]+temp[2];
                
                if(r>=0 && r<n && c>=0 && c<n && visited[r][c]==false){
                    vector<int> vec;
                    vec.push_back(matrix[r][c]); vec.push_back(r);vec.push_back(c);
                    pq.push(vec);
                    visited[r][c]=true;
                }
            }
            
        }
       
        /*if(pq.size()>0){
            vector<int> res = pq.top();
            return res[0];
        }
        
        
        return matrix[0][0];*/
        
        return last_popped;
        
        
    }
};