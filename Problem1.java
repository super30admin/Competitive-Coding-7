// Time Complexity : O(n log n).
// Space Complexity : O(n).
// Did this code successfully run on Leetcode : Yes
// Approach : We take two arrays one for start times and other for end times and sort them. We place two pointers i on start array and j
// end array. Initiated room with 1 as I am moving from second element in start array. If current start time is less than previous end \
// time, increase the room count. After comparision we increase start room pointer and continue until we reach end of start array.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.size();
        if(n == 0){
            return 0;
        }
        int[] start = new int[n]; //array for start times
        int[] end = new int[n]; //array for end times
        int rooms = 1;//intiate 1 as we start from 2nd element of start array

        for(int i = 0 ; i < n;i++){ //arrays intialization
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 1;//start from 2nd element
        int j = 0;//pointer on end array


        while(i < n && j<n){
            if(start[i] < end[j]){ //check if current start time is less than previous end time
                rooms++;
            } else{
                j++; //move pointer on end array
            }
            i++;//increment start array pointer
        }

        return rooms;
    }
}