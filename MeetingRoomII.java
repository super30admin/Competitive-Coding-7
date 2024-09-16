//Time complexity: O(NlogN), where N is the size of the intervals.
//Space complexity: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int[] arr:intervals){
            if(pq.isEmpty()) {
                pq.add(arr);
            }
            else{
                if(pq.peek()[1]<=arr[0]) {
                    pq.poll();
                }
                pq.offer(arr);
            }
        }
        return pq.size();
    }
}