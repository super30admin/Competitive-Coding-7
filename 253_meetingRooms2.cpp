// Time Complexity : O(NlogN)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    static bool cmp(vector<int> a, vector<int> b){
        return a[0] < b[0];
    }
    int minMeetingRooms(vector<vector<int>>& intervals) {
        if(intervals.size() ==0 || intervals.empty())
            return 0;
        sort(intervals.begin(), intervals.end(), cmp);
        priority_queue<int, vector<int>, greater<int>> pq;
        //pq.push(intervals[0][1]);
        int count = 1;
        for(vector<int> interval : intervals){
            if(pq.empty()){
                pq.push(interval[1]);
            }
            else{
                if(interval[0] >= pq.top()){
                    pq.pop();
                    pq.push(interval[1]);
                }
                else{
                    count++;
                    pq.push(interval[1]);
                }
            }
            
        }
        return count;
    }
};
