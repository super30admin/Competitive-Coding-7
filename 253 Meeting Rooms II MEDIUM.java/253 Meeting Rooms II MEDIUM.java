//253. Meeting Rooms II MEDIUM.java
//TIME O(nlog n)
//SPACE O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a,b) -> a[1] - b[1]);
        //functions by the end time criteria
        //taking start and end values for first interval;
        Integer[] temp = new Integer[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        pq.add(temp);
        for(int i = 1; i < intervals.length; ++i){
            Integer[] current = new Integer[2];
            current[0] = intervals[i][0];
            current[1] = intervals[i][1];
            Integer[] polled = pq.poll();
            if(polled[1] <= current[0]){
                current[0] = polled[0];
                pq.add(current);
            } else{
                pq.add(polled);
                pq.add(current);
            }
            //comparing current element with the polled element from the
        
        }
        return pq.size();
    }
}