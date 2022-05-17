/*
Problem: https://leetcode.com/problems/meeting-rooms-ii/
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        
        if (n == 1)
            return 1;
        
        int start[] = new int[n];
        int end[] = new int[n];
        
        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        int smallestEndIndex = 0;
        
        for (int i = 0; i < n; ++i) {
            if (start[i] < end[smallestEndIndex]) {
                ++rooms;
            } else {
                ++smallestEndIndex;
            }
        }
        
        return rooms;
    }
}