class Solution {
public int minMeetingRooms(int[][] intervals) {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Comparator<int[]> comp = new Comparator<>(){
        @Override
         public int compare(int[] o1, int[] o2){
             return o1[0] - o2[0];
         }
     };

     Arrays.sort(intervals,comp);
     pq.add(intervals[0][1]);

      for(int i = 1; i < intervals.length;i++){
          if( pq.peek() <= intervals[i][0]){
              pq.poll();
          }
           pq.add(intervals[i][1]);
      }
         return pq.size();
    }
}

//Time complexity : O(NlogN) there are N elements in the array and logN for extract min so NlogN
//Space complexity : O(N) in worst case all the elements will be in the priority queue
