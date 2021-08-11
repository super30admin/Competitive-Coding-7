class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0 || intervals == null) {
            return 0;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] interval : intervals) {
            
            int start = interval[0];
            int end = interval[1];
            
            if(!pq.isEmpty() && start >= pq.peek()) {
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
    }
}

//Time : O(nlogn)
//Space : O(n)