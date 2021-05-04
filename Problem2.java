import java.util.PriorityQueue;

//Kth Smallest Element in a Sorted Matrix
//tc - O(nlogn)
//sc - O(n) inserting all elements in pq

public class Problem2 {
    public static void main(String[] args){
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        Problem2 p = new Problem2();
        System.out.println(p.kthSmallest(matrix, 8));

    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i< n; i++){
            for(int j = 0;j< n;j++){
                   pq.offer(matrix[i][j]);
                
            }
        }
        while(!pq.isEmpty() && k > 1){
            pq.poll();
            k--;
        }
        return pq.poll();
    
}
}
