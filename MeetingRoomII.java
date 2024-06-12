class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //sorting the array based on start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        minHeap.add(intervals[0][1]);
        for(int i = 1; i< intervals.length; i++){
            if(minHeap.peek() <= intervals[i][0]){
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}
//Time Complexity: O(n)
// Space Complexity: O(n)