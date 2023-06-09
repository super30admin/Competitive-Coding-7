// Time Complexity : nlogn
// Space Complexity : n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// use a min heap storing only the end times.
// sort the intervals(ascending order) based on their start times. push the first interval into heap. as we require atleast 1 room.
// for each remaining intervals, check the top() value with the start time. if it overlaps, push new interval end time into heap 
// else we update the end time by poping and pushing.


class Solution {
public:
    static bool comp(vector<int>&a,vector<int>&b){
        return a[0] < b[0];
    }
    class func{
        public:
        bool operator()(int a,int b)
        {
            return a > b;
        }
    };
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),comp);
        priority_queue<int,vector<int>,func>pq;
        pq.push(intervals[0][1]);
        for(int i = 1;i<intervals.size();i++)
        {
            if(pq.top() <= intervals[i][0])
            {
                pq.pop();
                pq.push(intervals[i][1]);
            }
            else
            {
                pq.push(intervals[i][1]);
            }
        }
        return (int)pq.size();
    }
};