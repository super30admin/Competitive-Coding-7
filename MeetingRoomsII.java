package Nov29;

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        
        /*
        Time complexity: O(n log n) because we need to iterate through all n intervals in the input array. For  PQ usage, we will have time complexity log n. So, O(n log n) will be the time complexity. Also, Array.sort will have O(n log n) complexity. So overall log complexity is O(n log n + n log n) ~= O(n log n)
        
        Space Complexity: Additional space used by the PQ, which can at max have n entries for each of the n intervals in the input array when each of the intervals would need a different meeting room.
        
        Approach: Min heap used. Every entry in the min heap corresponds to one room. So, at the end of function, size of min heap would be used to find the min number of rooms in this problem.
    
        */
        
        // edge
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // sort the initial array, Sorting logic needs to be given since we got to sort it for custom object, array in this case.
        Arrays.sort(intervals, ((int[] a, int[] b) -> a[0] - b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        for (int[] cur: intervals) {
            int start = cur[0];
            int end = cur[1];
            // for example: when cur is (1,4) and PQ contains min number > start time of cur. So, for instance,PQ can have min element 3. In this case, the room in use by the meeting interval with end time=PQ peek element(min in PQ) can NOT be used by cur meeting interval. So, we need to add a new entry in the PQ to accomodate the cur meeting interval  because these both meetings can NOT happen in the same room due to overlapping timings.     
            if (pq.isEmpty() || pq.peek() > start)  {
                pq.add(end);
            } 
            // for example: when cur is (3,5) and PQ contains min number <= start time of cur. So, for instance, PQ can have min element 2 or 3. In this case, the room in use by the meeting interval with end time=PQ peek element(min in PQ) can be used by cur meeting interval. So, we can remove the min meeting interval entry from PQ and add cur meeting interval instead of that because these both meetings can happen in the same room due to non-overlapping timings.
            else {
                pq.poll();
                pq.add(end);
            }
        }
        
        return pq.size();

    }
}