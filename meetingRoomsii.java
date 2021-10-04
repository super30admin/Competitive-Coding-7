
import java.util.*;

public class HelloWorld{
    
    public static int meetingRoomsii(List<int[]> meetings) {
        Collections.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for(int[] arr: meetings) {
            if (pq.isEmpty()) {
                count++;
                pq.offer(arr[1]);
            } else {
                if(arr[0]<pq.peek()){
                    count++;
                } else {
                    pq.poll();
                }
                pq.offer(arr[1]);
            }
        }
        return count;
    }

     public static void main(String []args){
        List<int[]> li = new ArrayList<>();
        li.add(new int[] {1,5});
        li.add(new int[] {3,6});
        li.add(new int[] {9,11});
        li.add(new int[] {5,8});
        li.add(new int[] {3,4});
        System.out.println(meetingRoomsii(li));
     }
}