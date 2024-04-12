// nlogn 
// n
class Solution {
public:
    static bool cmp(vector<int>& a, vector<int>& b){
        if(a[0] == b[0])
            return a[1] < b[1];
        return a[0] < b[0];
    }
    int minMeetingRooms(vector<vector<int>>& intervals) {

        sort(intervals.begin(), intervals.end(), cmp);

        priority_queue<int, vector<int>, greater<int>> pq;

        int rooms = 0;

        for(int i = 0; i < intervals.size(); i++){
            if(!pq.empty() && pq.top() <= intervals[i][0]){
                pq.pop();
                pq.push(intervals[i][1]);
            }
            else{
                rooms++;
                pq.push(intervals[i][1]);
            }
        }
        return rooms;
    }
};
