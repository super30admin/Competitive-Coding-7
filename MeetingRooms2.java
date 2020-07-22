/* 
An array of meeting time intervals is given to you where every element consists of starting and ending time [[Start1,end1],[Start2,end2],...] (Starti < endi),you are required to find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.  
*/

// Time COmplexity - O(NlogN+NlogN) - For sorting + min heap
// Space Complexity - O(N) N = No of elements in the min heap queue in worst case

// Approach
// Sort the array initially according to the start time
// Put the elements in the min heap as we need the min end time for each of the activity.
// Compare the incoming activity with the latest activitiy finished's end time if the end time is lesser than the start time => same room.
// If the end time is greater than the start time of the incoming activity => Assign a new room

// https://leetcode.com/playground/R2G89Nos
// "static void main" must be defined in a public class.
public class Main {
  public static int conference(int[][] input) {
      if(input == null || input.length == 0) return 0;
      Arrays.sort(input[0]);
      int count = 0;
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Math.min(a[1],b[1]));
      for(int[] num: input) {
          if(!pq.isEmpty()) {
              if(pq.peek()[1] > num[0]) {
                  count++;
              } else {
                  pq.poll();
              }
          }
          pq.add(num);
      }
      return count;
  }
  public static void main(String[] args) {
      int[][] input = new int[][]{{0,30}, {5,10}, {15,20}};
      System.out.println(conference(input));
  }
}