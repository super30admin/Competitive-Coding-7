// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Use a min-heap to store end times of all meetings, so top of heap shows earliest time when a meeting room will be available
// 2. First sort the meetings as per start time and then iterate through them
// 3. If start of a meeting is at or after top of heap then update top of heap else add new end time to heap. 
// 4. Total number of unique meeting rooms used will be equal to size of the heap at the end

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
    	sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
    		return a[0] < b[0]; 
    	});

    	priority_queue<int, vector<int>, greater<int>> pq;
    	for(auto interval: intervals){
    		if(pq.size()!=0 && interval[0]>=pq.top())
    			pq.pop()
    		pq.push(interval[1]);
    	}
    	return pq.size();
    }
};