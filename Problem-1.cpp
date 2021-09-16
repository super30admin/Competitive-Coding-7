//Time Complexity = O(n*m)
//Space Complexity = O(n*m)
//where n is the number of rows and m is the number of coloumns in the matrix.
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int> pq;
        int i,j;
        int n = matrix.size();
        int m = matrix[0].size();
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                pq.push(matrix[i][j]);
                if(pq.size()>k){
                    pq.pop();
                }
            }
        }
        return pq.top();
    }
};

class Solution {
public:
     int getCount(vector<vector<int>> matrix, int mid){
     int count=0;
     int j=matrix.size()-1;
     for(int i=0;i<matrix.size();i++)
     {
         while(j>=0 && matrix[i][j]>mid)j--;
         count+=j+1;
     }
     return count;
    }
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
     int n = matrix.size();
     int left = matrix[0][0];
     int right = matrix[n-1][n-1];
     while(left<right)
     {
         int mid = left + (right-left)/2;
         int count= getCount(matrix,mid);
         if(count<k)left=mid+1;
         else right=mid;
     }
     return left;
    }
};
