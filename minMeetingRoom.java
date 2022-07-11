
// Time Complexity: O(log(n))
// Space Complexity: O(n) // Height of minHeap tree
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class minMeetingRoom {
    // "static void main" must be defined in a public class.
    private static int getOccupiedMeetingRoom(List<List<Integer>> rooms) {
        int n = rooms.size();
        // null
        if (n == 0 || rooms == null)
            return -1;
        rooms.sort((x, y) -> Integer.compare(x.get(0), y.get(0))); // sorting rooms

        // Creating minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (List<Integer> li : rooms) {
            // minHeap will not have any element inside it

            minHeap.add(li.get(1));
            
            if (minHeap.peek() < li.get(0)) { // Last meeting is over scenario
                minHeap.remove();
                minHeap.add(li.get(1));
            }
        }
        return minHeap.size() - 1;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        input.add(Arrays.asList(0, 6));
        input.add(Arrays.asList(7, 14));
        input.add(Arrays.asList(15, 20));
        // input.add(Arrays.asList(0, 15));
        // input.add(Arrays.asList(7, 9));

        System.out.println("Meeting rooms: " + input);
        System.out.println("Occupied Meeting Room: " + getOccupiedMeetingRoom(input));
    }
}
