//time- NlogN -#of meetings
//space-O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        //min_heap
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        
        for(int[] arr: intervals){
            
            if(!pq.isEmpty() && pq.peek()<= arr[0]){
            //remove and add
                
                pq.poll();
                
               //end time
            }
            
             pq.add(arr[1]); 
        }
        
        
        return pq.size();
        
    }
}