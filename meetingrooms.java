
//time complexity: O(n)
//space complexity: O(1)

//Sorting the intervals according to the starting time.
//Using a minheap to save the endTime for all intervals according to the order of start time.
//if cur start time < pq.peek() => means current start time is before first ending time, which means we must have a new room.
//if cur start time >= pq.peek() => means we can use this room for the meeting, we poll out the the original period and add current period to the queue. 

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;
        for(int i = 0; i < intervals.length; i++){
            pq.offer(intervals[i][1]);
            if(intervals[i][0] < pq.peek())  room++;
            else{
                pq.poll();
            }
        }
        return room;
    }
}