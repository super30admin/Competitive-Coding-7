
// Time Complexity : O(nlog n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minMeetingRooms(int[][] intervals) {
       
         Arrays.sort(intervals, (a, b) ->a[0]-b[0]); // soring on start basis

    
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1]-b[1]); 
        minHeap.add(intervals[0]);
        for(int i=1; i<intervals.length;i++){
            if(intervals[i][0] >= minHeap.peek()[1]){
                minHeap.poll();
            }
            minHeap.add(intervals[i]);
        }

       return minHeap.size();  
}
}