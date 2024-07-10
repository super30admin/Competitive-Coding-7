/***
 Using min Heap
 TC - O(nlogn)
 SC - O(n)
 */
class MeetingR {
    public int minMeetingRooms(int[][] intervals) {

        //sort based on end time
        Queue<Integer> minHeap = new PriorityQueue<>();

        int n = intervals.length;

        //sort the intervals based on the start time
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        //add the first meeting
        minHeap.add(intervals[0][1]);

        for(int i =1; i < n; i++) {
            if(intervals[i][0] >= minHeap.peek())
                minHeap.poll();

            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}