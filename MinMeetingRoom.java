// Time Complexity : O(n logn) n - length of interval array, 
// log n - sorting the array based on end in heap and start initially in arrays sort
// Space Complexity : O(n) - heap to store the interval end time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length ==0) return 0;
        Arrays.sort(intervals,(a,b) -> { 
           return a[0]-b[0]; 
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        heap.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(heap.peek() <= intervals[i][0])
                heap.poll();
            heap.add(intervals[i][1]);
        }
        return heap.size();
    }
}
