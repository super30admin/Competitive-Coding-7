//Time Complexity - O(NlonN)
//Space Complexity - O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        minHeap.add(intervals[0][1]);
        //compare with adjacent rooms and add to heap
        for(int i = 1; i< intervals.length; i++){
            if(minHeap.peek() <= intervals[i][0]){
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }else{
                minHeap.add(intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}