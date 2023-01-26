//Time Complexity: O(n logn)
//Space Complexity: O(n)

/*
 * we store the meeting timings in an heap based on thier end time.
 * if the new meeting start time is less than the min value we 
 * increase the count else we remove the prevoius meeting.
 */

public class Main {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{0,30}, {5,10}, {15, 20}, {15,35}};
        int count;
        PriorityQueue<Integer> pq;
        if(intervals == null || intervals.length == 0){
            System.out.println("0");
        }
        count = 0;
        pq = new PriorityQueue<>((a,b) -> a-b);
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        for(int i = 0; i < intervals.length; i++){
            pq.add(intervals[i][1]);
            if(intervals[i][0] < pq.peek())  count++;
            else{
                pq.poll();
            }
        }
        System.out.println(count);
    }
}