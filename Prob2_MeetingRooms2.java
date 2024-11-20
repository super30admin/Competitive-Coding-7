//TC : O(N * Log N)
//SC : O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0] );
        for(int[] vals : intervals){
            if(!queue.isEmpty() && queue.peek() <= vals[0]){
                queue.poll();    
            }
            queue.add(vals[1]);
            System.out.println(queue);
        }
        
        return queue.size();
    }
}