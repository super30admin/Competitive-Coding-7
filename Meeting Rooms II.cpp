// Meeting Rooms II
// Time Complexity: O(nlogk) where n is the number of intervals and k is the number of meeting rooms.
// Space Complexity: O(n)
// Did the code run successfully on LeetCode? Yes

// Approach:
// 1. Sort the intervals based on the start time.
// 2. Use a priority queue to keep track of the end times of meetings.
// 3. For each meeting, check if the room with the earliest end time is free.
// 4. If it is, pop it from the queue and push the new meeting's end time.
//5. If not, push the new meeting's end time into the queue.


#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>
using namespace std;
class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        //sort based on first character
        sort(intervals.begin(), intervals.end());
        for(int i = 0; i < intervals.size(); i++){
            cout<< intervals[i][0] << endl;
        }
        priority_queue<int, vector<int>, greater<int> >pq;
        pq.emplace(intervals[0][1]);
        for(int i = 1; i < intervals.size(); i++){
            if(intervals[i][0] >= pq.top()){
                cout<< "Popped: "<< pq.top()<<endl;
                pq.pop();
            }
            pq.push(intervals[i][1]);
            cout<<"Added: "<< intervals[i][1] << endl;
            
        }
        
        return pq.size();
    }
};