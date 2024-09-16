import java.util.*;

class Solution {
    // Meeting room two solution
    // Time complexity is O(nlogn)
    // Space complexity is O(n) i.e queue size
    public int solve(int[][] intervals) {
        // Edge case
        if(intervals == null || intervals.length == 0) return 0;

        // First sort the array based on start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i<intervals.length; i++){
            if(pq.peek() <= intervals[i][1]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = { { 0, 20 }, { 18, 25 }, { 10, 16 }, {8,12}, {23,20}, {15,28} };
        System.out.println(sol.solve(intervals));
    }
}