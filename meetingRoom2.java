import java.util.*;
class meetingRoom {
    public static void main(String[] args) {
        int [][] arra = {{0, 30}, {5, 10}, {15, 20},{1, 3}};
        System.out.println("rooms required " + meeting(arra));
    }

    private static int meeting(int [][] arra){
        Arrays.sort(arra, (a, b) -> a[0] - b[0]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] arr : arra){
            if(!pq.isEmpty()){
                int peek = pq.peek()[1];
                if(peek < arr[0]){
                    pq.remove();
                    //pq.add(arr);
                }
            }
            pq.add(arr);
        }
        return pq.size();
    } 
}
