class Solution {
    public int minMeetingRooms(int[][] intervals) {

        //sort based on start times
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer>heap = new PriorityQueue<>();
        for(int[] interval : intervals){
            int starttime = interval[0];
            int endtime = interval[1];
            if(!heap.isEmpty() && starttime >= heap.peek()) {
                heap.poll();
            }
            heap.add(interval[1]);
        }
        return heap.size();
        
    }
}