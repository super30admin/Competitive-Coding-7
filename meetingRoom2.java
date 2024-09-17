// Time Complexity - O(NlogN + NlogN) [sorting + insert operation in minHeap(heapify)]
// Space Complexity - O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


public class Main {

    public static int meetingRoom(int[][] intervals){

        if(intervals == null || intervals.length == 0)
            return 0;
        //sort the given array based on starting time of the meeting    
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            //remove the first element in queue, if end time of previous is less or equal to start time of new meeting 
            if(pq.peek() <= intervals[i][0]){
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        System.out.println(meetingRoom(intervals));
    }
}