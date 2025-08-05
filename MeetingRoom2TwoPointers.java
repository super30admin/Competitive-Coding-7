
//Time Complexity : O (n log n) -> sorting start and end time individually with each array containing n elements.
//Space Complexity : O (n) -> creating new start and end arrays

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        //base case
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        //separate out start and end times
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        //sort both start and end arrays
        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;

        int rooms = 0;

        while(s < start.length){

            if(start[s] >= end[e]){
                s++;
                e++;
            }
            else{
                rooms++;
                s++;
            }
        }

        return rooms;
    }
}