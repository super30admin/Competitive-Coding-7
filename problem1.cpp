//Time Complexity - O(number of valid arrangements)
//Space Complexity - O(N)s 
class Solution {
public:
    int ans=0;
    void helper(int n, int idx,vector<int>&v){
        if(idx==n+1){
            ans++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(v[i]==0&&(i%idx==0||idx%i==0)){
                v[i]=1;
                helper(n,idx+1,v);
                v[i]=0;
            }
        }
    }
    int countArrangement(int n) {
        vector<int>v(n+1);
        for(int i=0;i<=n;i++)
            v[i]=0;
        helper(n,1,v);
        return ans;
    }
};