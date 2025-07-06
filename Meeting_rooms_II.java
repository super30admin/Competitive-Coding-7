public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,(a,b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++){
            if(pq.peek() <= intervals.get(i).start){
                pq.poll();
            }
            pq.add(intervals.get(i).end);
        }

        return pq.size();
    }
}
