//Time = O(nlogn)
//space = O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int k=0;k<intervals.length;k++){
            start[k] = intervals[k][0];
            end[k] = intervals[k][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int i=0;
        int j=0;
        while(i<start.length && j<end.length){
            if(start[i]<end[j]){
                rooms++;
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return rooms;
    }
}
