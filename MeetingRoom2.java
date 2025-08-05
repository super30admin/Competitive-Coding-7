
// Time Complexity : O(n log n) -> sorting the input and adding/removing for n elements from the heap
// Space Complexity : O(n) -> worst case all meeting require a new room.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        //base case
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        //sort based upon start times
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            //get current interval
            int[] curr = intervals[i];

            //get min
            int minEnd = pq.peek();

            if(curr[0] >= minEnd){
                pq.poll();
            }
            
            pq.add(curr[1]);
        }

        return pq.size();
    }
}