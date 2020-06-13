//Leetcode: 253. Meeting Rooms II
//Time Complexity: O(nlogn) Building heap is nlogn. where n is number of meeting intervals
//Space Complexity: O(n), Heap size will be at max equal to number of intervals
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b)->(a[0]==b[0]?(a[1]-b[1]):(a[0]-b[0])));
        
        for(int[] in : intervals){
            pq.offer(in);
        }
        PriorityQueue<int[]> pqEnd= new PriorityQueue<>((int[] a,int[] b)->(a[1]-b[1]));
        pqEnd.offer(pq.poll());
        while(pq.size()>0){
            int[] meeting = pq.poll();
            int[] oldMeeting =pqEnd.peek();
            if(oldMeeting[1]>meeting[0]){
                
                pqEnd.offer(meeting);
            }
            else{
                oldMeeting= pqEnd.poll();
                oldMeeting[1]= meeting[1];
                pqEnd.offer(oldMeeting);
            }
        }
        
        return pqEnd.size() ;
        
    }
}