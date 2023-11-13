#include<bits/stdc++.h>
using namespace std;

/*
Approach: We check if any of the previous scheduled meeting has ended so that we could use that room. We do this by maintaining a min heap of ending times of the already scheduled meetings.
Time: O(nlogn)
Works on leetcode: yes 
*/

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        priority_queue<int, vector<int>, greater<int>> minHeap;

        int roomsUsed=0;
        for(vector<int> meeting: intervals) {
            int st = meeting.at(0);
            int end = meeting.at(1);

            while(!minHeap.empty() && minHeap.top()<=st) {
                minHeap.pop();
            }
            minHeap.push(end);
            roomsUsed = max(roomsUsed, (int)minHeap.size());
        }
        return roomsUsed;
    }
};