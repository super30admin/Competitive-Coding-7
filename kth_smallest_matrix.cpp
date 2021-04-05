//TC: O(N^2). Heap insertion is NlogK
//SC: O(k) since we store only k elements in the heap

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        
        
        if(matrix.size() == 0) return -1;
        
        priority_queue<int> maxHeap;
        
        for(int i=0; i<matrix.size(); i++){
            for(int j=0; j<matrix[i].size(); j++){
                
                maxHeap.push(matrix[i][j]);
                
                //store only the "k" smallest elements in the heap. 
                if(maxHeap.size() > k){
                    maxHeap.pop();
                }
                
            }
        }
        
        return maxHeap.top();
        
    }
};