// Time Complexity: O()
// Space Complexity: O()

class Solution {
int rooms(int [][] intervals){
PriorityQueue<Integer> pq = new PriorityQueue<>();
  Arrays.sort(intervals ,(a,b) -> a[0] - b[0]);
  for(int interval : intervals){
  if(pq.size()!=0 && pq.peek() <= interval[0]){
  pq.poll();
  }
    pq.add(interval[1]);
  }
  return pq.size();
}
}
