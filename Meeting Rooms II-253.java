// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
          for(int i=0;i<intervals.length;i++)
          {  int[] interval = new int[intervals[i].length];
             interval = intervals[i];
            if(pq.size() > 0 && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
        
    }
