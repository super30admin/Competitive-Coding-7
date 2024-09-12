//Time Complexity :O(N*Log(ans)).
//Space Complexity :O(N).
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope.


//Your code here along with comments explaining your approach

class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        List<Interval> meetings = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            meetings.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(meetings,new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });
        for(Interval i : meetings){
            if(pq.size() == 0 || pq.peek().end > i.start){
                pq.add(i);
            }else{
                pq.poll();
                pq.add(i);
            }
        }
    return pq.size();
    }
}
class Interval {
    int start, end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}