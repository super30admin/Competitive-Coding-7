package CompetitiveCoding7;
/*TC - O (NlogN) SC - O (N)*/
public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        
        //edge case
        if(intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++){
            int value = queue.peek();
            if(intervals[i][0] >= value){
                queue.remove();
                queue.add(intervals[i][1]);
            } else{
                queue.add(intervals[i][1]);
            }
        }
        
        return queue.size();
    }
}
}
