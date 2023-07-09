//Time Complexity - O(NlonN)
//Space Complexity - O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //sort
        Arrays.sort(intervals, (a, b) -> a[0]- b[0]);

        //compare with adjacent rooms and add to heap
        for(int i = 0; i< intervals.length; i++){
            if(!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0]){
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }else{
                minHeap.add(intervals[i][1]);

            }
        }
        return minHeap.size();
    }
}