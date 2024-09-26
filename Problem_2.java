//Time Complexity:O(nlogn)
//Space Complexity:O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(-1);
        for(int i=0;i<intervals.length;i++){
            if(pq.peek()<=intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}