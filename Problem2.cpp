// Time Complexity : O(n log n)
// Space Complexity : O(1) for two pointers, O(k) for heap approach 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Meeting Rooms - 2

#include<vector>
#include<iostream>
#include<queue>
#include <algorithm>

using namespace std;


struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};


// 2 pointers

class Solution {
public:
    int minMeetingRooms(vector<Interval> &intervals) {
        
        int count = 0;
        int result = 0;

        int n = intervals.size();
        vector<int> start;
        vector<int> end;
	
		for(int i = 0; i < n; i++) {
				start.push_back(intervals[i].start);
				end.push_back(intervals[i].end);
		}

        sort(start.begin(), start.end());
        sort(end.begin(), end.end());

        int i = 0;
        int j = 0;

        while(i < start.size()){
            if(start[i] < end[j]){
                count = count + 1;
                result = result < count ? count : result;   // we want total interview rooms used and not the rooms occupied in the end hence we store it in the result
                ++i;
            }
            else{
                count = count - 1;
                ++j;
            }
        }

        return result;
    }
};


// Priority Queue

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        
        sort(intervals.begin(), intervals.end(), [](const Interval& i1, const Interval& i2) -> bool {
            return i1.start < i2.start;
        });
        
        priority_queue<int, vector<int>, greater<int>> heap;    // we keep a min heap to keep the smallest end time at the top as we need to vacate the room to minimize interview rooms
        int rooms = 0;
        heap.push(intervals[0].end);
        rooms++;
        
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i].start < heap.top()) {
                rooms++;
            } else {
                heap.pop();
            }
            heap.push(intervals[i].end);    // keep adding end times, the larger ones will be at the lower levels 
        }
        
        return rooms;
    }
};