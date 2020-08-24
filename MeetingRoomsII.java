//TC: O(n log(n)), n: length of intervals[]
//SC: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int n = intervals.length;
        List<Meeting> meetings = new ArrayList();
        for(int i = 0; i < n; i++){
            Meeting meeting = new Meeting(intervals[i][0], intervals[i][1]);
            meetings.add(meeting);
        }
        Collections.sort(meetings, new Meeting());
        if(meetings.size() == 0) return 0;
        
        pq.add(meetings.get(0).endTime);
        for(int i = 1; i < meetings.size(); i++){
            if(meetings.get(i).startTime >= pq.peek()){
                pq.poll();
                pq.add(meetings.get(i).endTime);
            }
            else{
                pq.add(meetings.get(i).endTime);
            }
        }
        return pq.size();
    }
    
    class Meeting implements Comparator{
        int startTime; int endTime;
        public Meeting(){
            
        }
        public Meeting(int start, int end){
            this.startTime = start;
            this.endTime = end;
        }
        public int compare(Object meeting, Object meeting2){
            if(((Meeting)meeting).startTime < ((Meeting)meeting2).startTime) return -1;
            else if(((Meeting)meeting).startTime == ((Meeting)meeting2).startTime) return 0;
            else return 1;
        }
        
        public String toString(){
            return this.startTime +" "+ this.endTime;
        }
        
    }
    
}
