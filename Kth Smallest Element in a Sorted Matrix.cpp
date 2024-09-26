//Time Complexity- O(nlog(max-min))
//Space Complexity- O(1)

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        
        int n=matrix.size();
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=countLessThan(matrix,mid);
            if(count<k){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    
    int countLessThan(vector<vector<int>>& matrix,int val){
        
        int count=0;
        int r=0;
        int c=matrix[0].size()-1;
        
        while(r<matrix.size() && c>=0){
            
            if(matrix[r][c]>val){
                c--;
            }
            else{
                count+=c+1;
                r++;
            }
        }
        return count;
    }
};