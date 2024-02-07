/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
     //TC: O(n log n)
     //SC: O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int [] interval : intervals){
            if(pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}