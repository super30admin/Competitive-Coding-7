// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public int minMeetingRooms(List<Interval> intervals) {
    //sort by interval start time
    intervals.sort((a,b) -> a.start-b.start);
    //create PQ for rooms
    PriorityQueue<Integer> rooms = new PriorityQueue<>();
    //iterates through intervals
    for (int i = 0; i < intervals.size(); i++) {
        // if rooms isn't empty and first room in PQ has a smaller or equal start time to current interval, remove from heap
        if (!rooms.isEmpty()) {
            if (rooms.peek() <= intervals.get(i).start) {
                rooms.poll();
            }
        }
        // insert end time of current interval to rooms
        rooms.offer(intervals.get(i).end);
    }
    // return size of heap, aka rooms used
    return rooms.size();
}