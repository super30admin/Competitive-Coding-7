import java.util.*;

public class MyClass {

    public static void main(String[] args){
        
        int[][] input = new int[][]{new int[]{7,10},new int[]{2,4}};
        
        System.out.println(minMeetingRooms(input));
    }

    public static int minMeetingRooms(int[][] intervals) {

        // Sorting the input based on meeting start times
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });

        Queue<Integer> heap = new PriorityQueue<>();

        for(int[] interval : intervals){
            int startTime = interval[0];
            int endTime = interval[1];

            int peek = heap.isEmpty() ? Integer.MAX_VALUE: heap.peek(
            if(peek <= startTime){
                heap.poll();
            }
            heap.offer(endTime);
        }

        return heap.size();
}
}
