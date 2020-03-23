// time complexity - O(nlogn) Space - O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // sort on the basis of end time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        minHeap.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            // Step2 : If curr intervals start time is > then the heap.peek() pop from the heap
            if(!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()[1]){
                minHeap.poll();
            }
            minHeap.add(intervals[i]);
        }
        
        return minHeap.size();
        
    }
}