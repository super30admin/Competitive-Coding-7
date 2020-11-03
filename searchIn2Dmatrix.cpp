class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int> pq;
        for (auto i:matrix) {
            for (int j:i) {
                if (pq.size()<k) {
                    pq.push(j);
                  //  cout<<"push:"<<j<<endl;
                } else if ( j<pq.top()) {
                   // cout<<j<<" top:"<<pq.top()<<endl;
                    pq.pop();
                    pq.push(j);
                }
            }
        }
        return pq.top();
    }
};