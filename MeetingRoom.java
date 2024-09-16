// Time Complexity : O(n log n)
// Space Complexity : O(n)

// "static void main" must be defined in a public class.
public class Main {
    public static int meetingRoom(int[][] intervals){
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(pq.peek() <= intervals[i][0]){
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
       // int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        int[][] intervals = {{8, 10},{5, 6}}; 
        System.out.println(meetingRoom(intervals));
    }
}