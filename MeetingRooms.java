
//time - O(nlogn)
//sapce - O(n)
public class Main {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][] {{2,4}, {3,4}}));
    }
    
    public static int minMeetingRooms(int[][] intervals){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        for(int[] interval: intervals){
            if(!pq.isEmpty() && pq.peek() < interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
            
        }
        return pq.size();
    }
}
