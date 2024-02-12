class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        // Sort intervals based on the start time
       sort(intervals.begin(), intervals.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0];  // lambda function
        });

        // Use a min heap (priority queue) to keep track of end times
        priority_queue<int, vector<int>, greater<int>> pq;

        for (const auto& interval : intervals) {
            // If there is a meeting that has ended, use that room
            if (!pq.empty() && pq.top() <= interval[0]) {
                pq.pop();
            }
            // Add the end time of the current meeting to the priority queue
            pq.push(interval[1]);
        }

        // The size of the priority queue represents the minimum number of meeting rooms required
        return pq.size();
    }
};