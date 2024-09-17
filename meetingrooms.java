


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<intervals.length;i++){
            System.out.println("count = "+pq.size() + "pq.peek = "+ pq.peek());
            if(pq.isEmpty()){
                pq.add(intervals[i][1]);
                // count++;
            }else{
                if(intervals[i][0]>=pq.peek()){
                    pq.poll();
                    pq.add(intervals[i][1]);
                }else{
                    // count++;
                    pq.add(intervals[i][1]);
                }



            }




        }
        return pq.size();



    }
}