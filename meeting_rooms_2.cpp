// Time Complexity : O(n*logn) // Sorting + Traversal
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {

        // sort based on Start time        
        sort(intervals.begin(), intervals.end());
        
        // Maintain a min priority queue for tracking start and end times
        priority_queue<int, vector<int>, greater<int>> pq;
        
        int ret = 0;
        
        // Traverse based on start times
        for(const auto & m : intervals)
        {
            // Remove meetings finished
            while(pq.size() && m[0] >= pq.top())
                pq.pop();
            
            pq.push(m[1]);

            // Keep track of max rooms at any point   
            ret = max(int(ret), int(pq.size()));
        }
        
        return ret;
    }
};