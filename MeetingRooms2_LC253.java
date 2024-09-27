/*
time: O(n log n)  
n: no of schedules
log n- to insert in priority queue worst case => n 
space: O(n) - worst case, new room for every meeting
*/

class Solution {
    public int minMeetingRooms(int[][] schedule) {
        if(schedule == null || schedule.length == 0 || schedule[0].length == 0) return 0;
        
        Arrays.sort(schedule, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        pq.add(schedule[0][1]);
        for(int i = 1; i < schedule.length; i++){
            int prevEnd = pq.peek(); 
            int start = schedule[i][0];
            int end = schedule[i][1];
            
            if(start >= prevEnd)
                pq.poll();
            pq.add(end);
        }
        return pq.size();
    }
}