// https://leetcode.com/problems/meeting-rooms-ii/description/

// 253. Meeting Rooms II
// Medium
// 6.6K
// 139
// company
// Google
// company
// TikTok
// company
// Amazon
// Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

// Example 1:

// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2
// Example 2:

// Input: intervals = [[7,10],[2,4]]
// Output: 1
 

// Constraints:

// 1 <= intervals.length <= 104
// 0 <= starti < endi <= 106


// Time Complexity : O(nlog(n) + nlog(n)))

// Space Complexity :O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could not figure out the intuition behind sorting the array and using the priority queue. Had to take help from hints


// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //Sort the array based on start time
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        int count= 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        //Process the array based on end time in priority queue and start time in array
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < pq.peek()){
                pq.add(intervals[i][1]);
            }
            else{
                pq.poll();
                pq.add(intervals[i][1]);
            }

            count = Math.max(count, pq.size());
        }
        return count;
    }
}

// 4 9     4 17    9 10 