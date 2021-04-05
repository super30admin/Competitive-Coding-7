class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
     if(intervals == null || intervals.length == 0){
         return 0;
     }   
        //sort array with starting time
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
       
        for( int[] i : intervals)
        {if(!pq.isEmpty())
        {
            int[] current =pq.peek();
            if(i[0] >= current[1])
            {
                pq.poll();
            }
        }
        pq.add(i);
        }
        return pq.size();
    }
} 