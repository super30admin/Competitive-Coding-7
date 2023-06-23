//TC:O(nlogn)
//SC: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] interval: intervals){
            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
           pq.add(interval[1]);
            
        }
        return pq.size();
    }
}
