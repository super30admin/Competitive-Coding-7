//Time Complexity: O(n log n) where n is the number of intervals
//Space Complexity: O(n)

//Successfully runs on leetcode: 6 ms

//Approach: Here we first sort the array based on start times and then maintain a min heap to compare the minimum
// end time and the next start time. If the minimum end time is less than or equals the next start time i.e 
//the previous meeting will be over by the time new meeting starts and we will not require extra room, we poll the room.
//In the end, size of the queue will give the minimum rooms required.



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval: intervals)
        {
            if(!pq.isEmpty() && pq.peek() <= interval[0])
                pq.poll();
            pq.add(interval[1]);
        }
        return pq.size();
    }
}