// Time Complexity : O(n) where n is the size of intervals
// Space Complexity : O(k) where k is the number total meetings rooms required, also that will be the size of heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));


        PriorityQueue<Integer> q = new PriorityQueue<>();


        for(int[] interval : intervals){
            if(!q.isEmpty() && q.peek() <= interval[0]){
                q.poll();
            }
            q.add(interval[1]);

        }


        return q.size();
    }
}
