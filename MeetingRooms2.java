//Problem 95 : Kth Smallest Element in a Sorted Matrix
//TC: O(nlogn) + O(intervals array size)
//SC: O(intervals array size)

/*
  Bruteforce : O(nlogn)+intervals.length * list.size()
               1)Sort the array.
               2)Just use a list data structure for storing the end time. On terating over the intervals array, each time iterate over the list and check if current start>=any list element just update that element with the current end time. Otherwise if all the elemnts in the list are gtreater then just add current elemnt end time to the list.
               Finally return the list size.
   
  Optimised: TC: O(nlogn) + O(intervals array size) | SC:O(intervals array size)
            1) Sort the array
            2) Use the concept of min heap. Store end time of the meeting in the the heap.
            3) Iterate over the intervals starting from 2nd index and check if current element start>=peek element end, just poll it because we don't need that. And keep inserting the current eleemnt end time in heap.
            Finally return the heap size that will be the answer.              

*/

import java.util.*;
class Solution95 {
   
    public int minMeetingRooms(int[][] intervals) {
       
        if(intervals==null || intervals.length==0) return 0;
        //TC:O(nlogn) + O(intervals array size) | SC:O(intervals array size)
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.offer(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            
            if(intervals[i][0]>=minHeap.peek()){
                minHeap.poll();
            }
            
            minHeap.add(intervals[i][1]);
            
        }
            
        return minHeap.size();
    }


    /*Bruteforce
    TC: O(nlogn)+intervals.length * list.size()
    SC: O(n)
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals==null || intervals.length==0) return 0;
        
        //TC: O(nlogn)+intervals.length * list.size()
        //SC: O(n)
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            boolean toBeAdded= true;
            for(int j=0;j<list.size();j++){
                if(intervals[i][0]>=list.get(j)){
                    list.set(j,intervals[i][1]);
                    toBeAdded = false;
                    break;
                }
            }
            
            if(toBeAdded) list.add(intervals[i][1]);
        }
        
        
      return list.size();    
    }*/
}

