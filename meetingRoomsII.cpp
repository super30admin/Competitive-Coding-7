//time complexity:O(nlogn)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using min heap
//any issues faced? no

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        priority_queue<int, vector<int>, greater<int>>rooms;
        for(int i=0; i<intervals.size(); i++)
        {
            if(rooms.empty())
            {
                rooms.push(intervals[i][1]);
            }
            else if(intervals[i][0]<rooms.top())
            {
                rooms.push(intervals[i][1]);
            }
            else
            {
                rooms.pop();
                rooms.push(intervals[i][1]);
            }
        }
        return rooms.size();
    }
};

