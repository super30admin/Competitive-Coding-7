Time Complexity - O(n*nlogn)
Space Complexity - O(n)

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        //O(nlogn)
        sort(intervals.begin(), intervals.end(), [](const Interval& i1, const Interval& i2) -> bool {
            return i1.start < i2.start;
        });
        
        priority_queue<int, vector<int>, greater<int>> heap;
        int rooms = 0;
        heap.push(intervals[0].end);
        rooms++;
        //O(n*nlog(n))
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i].start < heap.top()) {
                rooms++;
            } else {
                heap.pop();
            }
            heap.push(intervals[i].end);
        }
        
        return rooms;
    }
};