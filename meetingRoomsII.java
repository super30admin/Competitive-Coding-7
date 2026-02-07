class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Queue<int[]> minH = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

       // minH.offer(intervals[0]);

        for(int i =0; i< intervals.length; i++){
            int[] curr = intervals[i];

            if(!minH.isEmpty() && minH.peek()[1] <= curr[0])
                minH.poll();
            
            minH.offer(curr);
        }
    return minH.size();
    }
}