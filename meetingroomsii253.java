/*
T - O(NlogN)
S - O(N)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( new Comparator<int[]>() {
            public int compare(int[] a, int[] b) { return a[1] - b[1]; }
        });

        pq.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(pq.peek()[1]>intervals[i][0]){
                pq.offer(intervals[i]);
            }
            else{
                pq.poll();
                pq.offer(intervals[i]);
            }
        }
        return pq.size();

    }
}