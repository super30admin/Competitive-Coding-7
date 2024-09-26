    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/meeting-rooms-ii/
    Time Complexity for operators : o(nlogn) .. n is the input length
    Extra Space Complexity for operators : o(n) .. worst case min heap size 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Iterate thru two-d array and check elelemnt by elemnt after sort.
        # Optimized approach: 
                              
            # 1. 
                A) Create a priority queue as a min heap.
                B) First sort the  intervals on the  basis of start time.
                C) Then add first elements from intervals.
                D) Then for loop to go over each and every row. If the value of 
                   (intervals[i][0] >= pq.peek()) checking end time of first element with start time of 2nd
                   then poll the min top most element. Add element to the Priority Queue.
                E) At the end, return size of the Priority Queue.
        */


class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0)
            return 0;
        
        // interanly it is min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // n logn
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(final int[] i1, final int[] i2){
                return i1[0] - i2[0];   
            }
        });

        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= pq.peek())
                pq.poll();
            
            pq.add(intervals[i][1]);
        }
        
        System.out.println(pq);
        return pq.size();
    }
}