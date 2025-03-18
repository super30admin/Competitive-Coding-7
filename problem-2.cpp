// https://leetcode.com/problems/meeting-rooms-ii/description/
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    public:
        int minMeetingRooms(vector<vector<int>>& intervals) {
            sort(intervals.begin(), intervals.end());
            priority_queue<int, vector<int>, greater<int>> pq;
            for(auto interval : intervals){
                if(!pq.empty() && pq.top() <= interval[0]){
                    pq.pop();
                }
                pq.push(interval[1]);
            }
            return pq.size();
        }
    };