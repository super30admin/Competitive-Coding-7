// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We use Two pointers approach to find the min meeting rooms to take place without conflict
//we take two sorted arrays to maintain the start and the end time
//we check if the start time is less than or equal to the end time then a meeting is ongoing and we need to allocate a separate room
// if not we can reuse the existing room since the meeting is ended before another starts

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int [] start = new int[n];
        int [] end = new int[n];

        for(int i = 0; i< n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0; s = 0; e = 0;
        int res = 0;
        while(s < n) {
            if (start[s] <= end[e]) {
                //overlapping meetings
                rooms++;
                s++;
            } else {
                //reuse the room
                rooms--;
                e++;
            }
            res = Math.max(res,rooms);
        }
        return res;

    }
}
