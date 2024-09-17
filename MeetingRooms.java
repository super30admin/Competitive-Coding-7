//Time Complexity : O(nlogn)
//Space Complexity : O(n)

/**
 * Definition of Interval:
 * public classs Interval {
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
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        
        if(intervals.size()<0 || intervals==null){
            return -1;
        }
        
        Comparator<Interval> sortByStart = (Interval i1, Interval i2) -> i1.start-i2.start;
        Collections.sort(intervals, sortByStart);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals.get(0).end);
        
        for(int i=1; i<intervals.size();i++){
            int meeting_end_time = heap.peek();
            if(meeting_end_time <= intervals.get(i).start){
                heap.poll();
            }
            heap.offer(intervals.get(i).end);
            
        }
        
        return heap.size();
        
        
    }
}