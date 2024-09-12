// Time Complexity : O(nlogn + nlogn), input array size (custom sorting) and (heapify of n times)
// Space Complexity : O(n), worst case heap size is input size, will require n rooms
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Use a custom sort, to sort intervals based on the starting time
//Create a min heap to add the endtime
//Before adding the endtime of the ith interval into the heap,
//the starttime of the ith interval is checked with the top of the heap (end time)
//if the starttime of the ith interval >= to the endtime of the top of heap
//(it means we can use the same room for the ith interval and the top element of the heap)
//the top of heap is removed, and the endtime of the ith interval is added to the heap
//in the end : Number of rooms = size of heap (we need these many rooms)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //check for null and 0 case
        if(intervals == null || intervals.length == 0) return 0;
        
        //MinHeap for end time
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);

        //Custom sort using Comparator
        Arrays.sort(
            intervals, new Comparator<int[]>() {
                public int compare (int[] a, int[] b) {
                    return a[0] - b[0];
                }
            }  
        );
        
        //add the first endtime to the PQ, to compare the next starttime with it
        pq.add(intervals[0][1]);
        //iterate through other the intervals 
        for(int i = 1; i < intervals.length; i++) {
            //check if starttime (of ith interval) >= endtime of top of PQ
            if(intervals[i][0] >= pq.peek()) {
                //if so, remove the interval from PQ
                //and add the endtime of ith interval
                pq.remove();
                pq.add(intervals[i][1]);
            }
            else {
                //else just add the endtime of the interval to PQ
                pq.add(intervals[i][1]);
            }
        }   
        //number of different rooms needed = size of PQ
        return pq.size();   
    }
}

