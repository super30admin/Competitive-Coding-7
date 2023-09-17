//Using MinHeap
//TC: N O(log N)
//SC: O(N)
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Sort the intervals based on start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        // Priority queue for end times
        //Min Heap to keep track of minimum close times, so that
        // next interval can be in the same (peek) conference room thereby reducing the number of rooms required
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Interval interval : intervals) {

            // if minimum close time among already allocated rooms is before the current interval start time,
            // put this current interval in that peek (min-close time) conference room
            if(!pq.isEmpty() && pq.peek() <= interval.start) {
                pq.poll();
            }
            pq.add(interval.end);
        }
        return pq.size();

    }
}