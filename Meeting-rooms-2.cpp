// Time Complexity : O(n + log n) 

// Space Complexity : O(N) - maxHeap

// Did this code successfully run on Leetcode : YES

// Appoarch: Sort the intervals. Using maxheap, push end to pq and compare with next start.

// 253. Meeting Rooms II

#include <bits/stdc++.h>
using namespace std;

class cmp {
public:
    bool operator()(const int& a, const int& b) const {
        return a > b;  
    }
};
class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int cnt = 0;
        priority_queue<int,vector<int>,cmp> pq;
        for(auto interval : intervals){
            int start = interval[0];
            int end = interval[1];
            while(!pq.empty() && pq.top() <= start){
                pq.pop();
            }
            pq.push(end);
            cnt = max(cnt,(int)pq.size());
        }
        return cnt;
    }
    
};