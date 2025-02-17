import java.util.Arrays;

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes/No
 * Any problem you faced while coding this: None

 * Approach:
 * Using two pointers, check if a start of meeting is after another meeting ends and allocate a room accordingly.
 * For that - first sort start time and end
 */

public class MinimumMeeting2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        int[] startingTime = new int[n];
        int[] endingTime = new int[n];

        for (int i = 0; i < n;i++) {
            startingTime[i] = intervals[i][0];
            endingTime[i] = intervals[i][1];
        }

        // 1. Sort started
        // 2. Sort end
        Arrays.sort(startingTime);
        Arrays.sort(endingTime);

        // 3. Go over the started array
        int room = 0;
        int end = 0;

        // 3a. Check if any meeting had ended - start time > end time
        // 3b. room++;
        for (int start = 0; start < n; start++) {
            if (startingTime[start] >= endingTime[end]) {
                end++;
            } else {
                room++;
            }
        }

        return room;
    }

    public static void main(String[] args) {
        // Your code here
        MinimumMeeting2 obj = new MinimumMeeting2();
        int count = obj.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {10, 20}});
        System.out.println(count);
        assert(count == 2);
    }
}