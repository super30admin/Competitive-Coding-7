/* Time: O(nlogn)
Space: O(n) -- heap size
*/
class Solution {
    int rooms=1;
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]); //sort intervals based on start time

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap to store the end time of meetings
        pq.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0]>=pq.peek()){
                pq.poll();
            }

            pq.add(intervals[i][1]);

        }

        return pq.size();

    }
}
