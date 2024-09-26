class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        // 1. we need sort this array in terms of start time
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        // 2. we need build one priority queue to store the end time with min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        // 3. we need offer one meeting inside the min heap
        minHeap.offer(intervals[0][1]);
        for(int i = 1; i < len; i++){
            int endTime = minHeap.peek();
            // 4. we compare the end time with the start time to check whether we need new rooms
            if(endTime <= intervals[i][0]){
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        // 5. the size of the min heap will be the answer
        return minHeap.size();
    }
}