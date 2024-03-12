// Time: O(nlongn)
// Space: O(n)

// Approach: Sort the start and end arrays separately. 
// Use two pointers and keep track of rooms required.

import java.util.Arrays;

class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimeArr = new int[intervals.length];
        int[] endTimeArr = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimeArr[i] = intervals[i][0];
            endTimeArr[i] = intervals[i][1];
        }

        Arrays.sort(startTimeArr);
        Arrays.sort(endTimeArr);

        int currentRooms = 0;
        int res = 0;

        int i = 0;
        int j = 0;

        while (i < startTimeArr.length) {
            if (startTimeArr[i] < endTimeArr[j]) {
                currentRooms++;
                res = Math.max(res, currentRooms);
                i++;
            } else {
                currentRooms--;
                j++;
            }
        }

        return res;
    }
}