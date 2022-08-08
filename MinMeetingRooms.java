//Time Complexity: O(n logn + n) = O(n logn) for sorting and going over interval length
//Space Compexity: O(n), where n is the interval length (for priority queue)
//Did it run successfully on leetcode: Yes
//Did you face any problem coding this challenge: No

class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {

        //sort the start time of the intervals
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        //Priority queue to maintain the least element at the top of the stack always.

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int[] interval: intervals) {

            //Check if the priority queue is not empty and the top element in the stack is less than the current interval's start time and remove that element if true (if there is no overlapping between two intervals, we can merge those intervals and assign the same meeting room.
            if(!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            //add the current element's end interval time to the priority queue
            pq.add(interval[1]);
        }

        //return the size of the priority queue
        return pq.size();
    }
}