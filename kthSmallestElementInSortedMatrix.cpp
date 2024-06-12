//time complexity:O(x+klogx)
//space complexity:O(x)
//executed on leetcode: yes
//approach:using min heap
//any issues faced? yes, very tricky

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>>q;
        int n=matrix.size();
        for(int i=0;i<n;i++)
        {
            q.push({matrix[0][i],{0,i}});
        }
        int ans;
        while(k--)
        {
            int val=q.top().first;
            int row=q.top().second.first;
            int col=q.top().second.second;
            q.pop();
            ans=val;
            if(row!=n-1)
            {
                q.push({matrix[row+1][col],{row+1,col}});
            }
        }
        return ans;
    }
};