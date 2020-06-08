// Time Complexity : O(nlog n) where n is the number of activities taking place (Sorting by start time + Adding to the Min heap)
// Space Complexity : O(n) where n is the number of activities in the min heap queue at the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Sorting by start time strategy before using heap for the end time strategy (required hints)
/* Your code here along with comments explaining your approach: As the events are parsed, sort the array initially according to the start time so that
we have all the activities in order that are going to take place. Put it in the min heap as we need the min end time for each of the activity. Compare
the incoming activity with the latest activitiy finished's end time if the end time is lesser than the start time => we can reassign the same room.
Hence, if the end time is greater than the start time of the incoming activity => previous activity is still going, we need to assign a new room, hence
counter is incremented.
*/
class Main {
    public static int conference(int[][] input){
      if(input == null || input.length == 0){return 0;}
      Arrays.sort(input[0]);                                                                    // Sort by the start time
      int count  = 0;
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Math.min(a[1],b[1]));           // Put it in with the min end time 
      for(int[] num: input){
        if(!pq.isEmpty()){
        if(pq.peek()[1] > num[0]){                                                      // if the previous activity end time is greater than the new activitiy start time
          count++;                                                                      // New room needed
        } else {
          pq.poll();                                                                    // Activity is finished, pop the previous activity
        }
        }
        pq.add(num);                                                                        // Add the new activity to check the status
      }
      return count;                                                                             // Return the number of rooms
    }
  
    public static void main(String[] args) {
      int[][] input = new int[][]{{0,30}, {5,10}, {15,20}};
      int re = conference(input);                                                               // Call the function
      System.out.println(re);
    }
  }