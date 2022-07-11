//Time Complexity- O(nlog(n))
//Space Complexity- O(n)

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        
        if(intervals.size()==0 || intervals[0].size()==0){
            return 0;
        }
        sort(intervals.begin(),intervals.end());
        priority_queue<int,vector<int>,greater<int>> pq;
        pq.push(intervals[0][1]);
        
        for(int i=1;i<intervals.size();i++){
            if(pq.size()>0){
                int minEnd=pq.top();
                if(intervals[i][0]>=minEnd){
                    pq.pop();
                }
            }
            pq.push(intervals[i][1]);
        }
        return pq.size();
    }
};