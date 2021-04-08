class MeetingRoomsII {

    // Time Complexity: O(nlogn)    (where n -> no. of intervals in the array)
    // Space Complexity: O(n)

    public int minMeetingRooms(int[][] intervals){
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return 0;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        maxHeap.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int[] prev = maxHeap.poll();
            if(curr[0] < prev[1]){
                maxHeap.add(curr);
                maxHeap.add(prev);
            }else{
                prev[1] = curr[1];
                maxHeap.add(prev);
            }
        }

        return maxHeap.size();
    }
}