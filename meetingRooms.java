//Time complexity: O(N + NlogN) //sorting O(nlogn) + iterating O(n)+ minheap inserts O(nlogn)
//Space complexity: O(N) //for pq
// "static void main" must be defined in a public class.
public class Main {
    
    public static int meetingRooms(int[][] meetings){
        if(meetings == null || meetings.length == 0){
            return 0;
        }
        
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meetings[0][1]);
        
        for(int i = 1; i < meetings.length; i++){
            
            //compare the smallest end time with the current start time
            if(pq.peek() < meetings[i][0]){
                pq.poll();
            }
            
            pq.add(meetings[i][1]);
        }
        
        return pq.size();
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 30}, {7, 45}, {15, 20}, {5, 10}};
        
        System.out.println(meetingRooms(arr));
    }
}