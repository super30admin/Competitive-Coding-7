//Time complexity-O(n)
//Space Complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq= new PriorityQueue<>();//creating in heap and adding the end time of each meeting
        for(int[] interval: intervals){
            if(pq.size()>0 && interval[0]>=pq.peek()){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
        
    }
}
