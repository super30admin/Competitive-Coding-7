//Approach - Collect all the start times in an array, collect all the end times in an array
//          if the start time is earlier than the end time, allocate one room
//Time Complexity - O(NlogN)
//Space Complexity - O(2N) = O(N)
class Solution {
  public int minMeetingRooms(int[][] intervals) {

    int n = intervals.length;
    int[] start = new int[n];
    int[] end = new int[n];

    int index=0;

    for(int[] interval: intervals){
      start[index] = interval[0];
      end[index] = interval[1];
      index++;
    }

    Arrays.sort(start);
    Arrays.sort(end);

    int p1 = 0, p2 = 0;
    int result=0;

    while(p1 < n && p2 < n){
      if(start[p1] < end[p2]){
        result++;
      }
      else{
        p2++;
      }
      p1++;
    }
    return result;
  }
}


//Same Logic - but instead of 2 arrays just 1 PriorityQueue
//Time Complexity - O(NlogN) - N is length of intervals
//Space Complexity - O(N)

class Solution {
  public int minMeetingRooms(int[][] intervals) {

    int n = intervals.length;

    PriorityQueue<Integer> endQueue = new PriorityQueue<Integer>((a,b) -> a-b);

    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    endQueue.add(intervals[0][1]);

    int result=0;

    for(int i=1; i<n; i++){
      int end = endQueue.peek();
      if(intervals[i][0] >= end){
        endQueue.poll();
      }
      endQueue.add(intervals[i][1]);
    }

    return endQueue.size();
  }
}
