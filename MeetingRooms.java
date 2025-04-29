class minMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals,  Comparator.comparingInt(o-> o[0]));
       for(int i=0; i<intervals.length; i++){
        if(!pq.isEmpty())
        {
          if(intervals[i][0] >= pq.peek())
          {
            pq.poll();
            pq.add(intervals[i][1]);
          }
          else{
           pq.add(intervals[i][1]);
          }
        }
        else
            pq.add(intervals[i][1]);
    }
    return pq.size();
}
}