// Time Complexity : o(nlogn) sort list and traverse it
// Space Complexity : o(k) k=no of rooms
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,(s1,s2)->s1.start-s2.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        for(int i=1;i<intervals.size();i++){
            int top=pq.peek();
            if(top<=intervals.get(i).start){
                pq.poll();
            }
            pq.add(intervals.get(i).end);
           
        }
        return pq.size();
    }
}