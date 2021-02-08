/*
Time : O(NxM) | time to iterate over 2d matrix
Space : O(NxM) | Worst case we will be storing each meeting interval
Leetcode : Yes
*/
class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {        
        if(intervals == null || intervals.length == 0) return 0;
        Queue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, ((a,b) -> (a[0] - b[0])));
        
        pq.add(intervals[0][1]);
        
        for(int i = 1; i< intervals.length; i++){
            
            if(pq.peek() <= intervals[i][0]){
                pq.poll();
                
            }
            pq.add(intervals[i][1]);          
        }
        
        return pq.size();
    }
}
