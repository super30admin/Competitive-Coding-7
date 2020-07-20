//Time complexity:O(nlogn)
//Space complexity:O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0 ){
            return 0;
        }
        Comparator<int[]> c=(int[] a,int[] b)->a[0]-b[0];
        Arrays.sort(intervals,c);
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int[] i:intervals){
            int start=i[0];
            int end=i[1];
            if(!pq.isEmpty() && start>=pq.peek()){
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
        
    }
}