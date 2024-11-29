class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int[] meet:intervals){
            if(q.isEmpty() || q.peek()<=meet[0]){
                q.poll();
            }
            q.add(meet[1]);
        }
        return q.size();
    }
}
