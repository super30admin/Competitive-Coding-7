// Time Complexity : O(N) 
// Space Complexity : O(N) hashtable size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Add the end timings to minHeap sorted on the end timings.
2. If the starting of next meeting is less the end timings inside the minHeap then pop the minHeap min value.
3. If the starting of next meeting is greater the end timings then add the end timings to the minHeap.
4. Result is the length of the minHeap
*/


// Your code here along with comments explaining your approach
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.MRBS(new int[][]{{0,15}, {5,32}, {15,20}, {6,16}}));
    }
    
    public int MRBS(int[][] meetings) {
        if(meetings.length == 0) return 0;
        if(meetings.length == 1) return 1;
        PriorityQueue<Integer> endTimings = new PriorityQueue<Integer>((a,b) -> a - b);
        Arrays.sort(meetings, ((a,b) -> a[0] - b[0]));
        //{0,15}, {5,32}, {6,16}, {15,20}
        for(int[] meeting: meetings) {
            System.out.println(Arrays.toString(meeting));
            if(!endTimings.isEmpty()) {
                int curentMinMeeting = endTimings.peek();
                if(meeting[0] >= curentMinMeeting) {
                    endTimings.poll();
                    endTimings.add(meeting[1]);
                } else {
                    endTimings.add(meeting[1]);
                }
            } else {
                endTimings.add(meeting[1]);
            }
        }
        return endTimings.size();
    }
}
