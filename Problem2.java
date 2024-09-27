//Meeting-rooms II
//Time complexity : O(Nlog(N)) + N
//Space Complexity: O(N)

/**
 * First creating two arrays for start and end intervals to compare the start of one meeting with the end of next meetings
 * Then sorting these two arrays. Then, using a two pointer approach to check which meeting is still going on to calculate
 * the number of rooms required.
 */

class Problem2 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i =0; i<n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0, room =0;
        int result = 1;
        while(i<start.length && j<end.length){
            if(start[i]<end[j]){
                //room needed
                i++;
                room++;
            }
            else{
                //room not required
                j++;
                room--;
            }
            result = Integer.max(result,room);
        }
        return result;
    }
}