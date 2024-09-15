// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });
        // for(int[] arr:intervals){
        //     System.out.println(Arrays.toString(arr));
        // }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(a-b));
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(pq.peek() <= intervals[i][0]) pq.poll();
             pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}