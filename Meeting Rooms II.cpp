//time: O(nlogn) space: O(n)
class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        priority_queue<int, vector<int>, greater<int>> pq;
        sort(intervals.begin(), intervals.end());
        int result = 0;
        for(int i = 0; i < intervals.size(); i++) {
            if(pq.size() == 0) {
                pq.push(intervals[i][1]);
                result++; // push 30
            }
            else {
                if(intervals[i][0] < pq.top()) {
                    result++; // 2
                    pq.push(intervals[i][1]); // push 10,30
                }
                else {
                    pq.pop(); // 30
                    pq.push(intervals[i][1]); // 20 30
                }
            }
        }
        return result;
    }
};