// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach

// Sort the array on the start times and if any time is lesser than heap.peek() remove else increase the count

public int minMeetingRooms(int[][] intervals) {

    Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
 
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    int count = 0;

    for (int[] itv : intervals) {
        if (heap.isEmpty()) {
            count++;
            heap.offer(itv[1]);
        } else {
            if (itv[0] >= heap.peek()) {
                heap.poll();
            } else {
                count++;
            }
 
            heap.offer(itv[1]);
        }
    }
 
    return count;
}