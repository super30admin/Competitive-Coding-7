import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // TC: O(n log n) SC: O(n)
    private static int minMeetingRooms(int[][] intervals){
        if(intervals != null && intervals.length <= 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap .. end time
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]); //start time
        for (int i = 0; i < intervals.length - 1; i++) {
            if(!pq.isEmpty() && intervals[i][0] >= pq.peek()){
                pq.poll(); //popping the min element in the heap
            }
            pq.add(intervals[i][1]);
        }
        return  pq.size();
    }

    // TC: O(n log k)  SC: O(k) where K is constant
    public static int kthSmallest_1(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));  //max heap
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 15}, {9, 18}, {16, 25},{26,30},{31,35}};
        int result1 = minMeetingRooms(intervals1);
        System.out.println("min meeting room result1 is " + result1);


    }
}





