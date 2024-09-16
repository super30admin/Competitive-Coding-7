/*
Time Complexity: O(nlogn)
Space Complexity : O(n)

*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
            
        //base case
        if (intervals == null || intervals.length == 0)
            return 0;
        //sort by start time
        
       Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b) {
            return a[0] - b[0];
            }
        });
        
        
        int count = 0;
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for (int i = 1 ; i < intervals.length;i++) {
            int prevEnd = pq.peek();
            if(prevEnd > intervals[i][0]) {
                pq.add(intervals[i][1]);
            }
            else {
                int prev = pq.poll();
                pq.add(intervals[i][1]);
            }
        }
            
            return pq.size() ;
        
        }
}
