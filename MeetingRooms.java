/*
Passed All Test Cases 
Big O 
Time -> O(NlogN), N is # of elements in intervals
Space -> O(N). N is # of elements in intervals
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //edge case
        if(intervals.length == 0) return 0 ; 
        
        //sorting the intervals according to their start times 
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int [] a, int [] b) {
                return a[0] - b[0] ; 
            }
        }) ; 
        
        //initializing min heap 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>() ; 
        
        minHeap.add(intervals[0][1]) ; 
        
        //checking for the other intervals
        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i][0] < minHeap.peek())
                minHeap.add(intervals[i][1]) ; 
            else {
                minHeap.remove() ; 
                minHeap.add(intervals[i][1]) ; 
                }
        }
        return minHeap.size();  
    }
}