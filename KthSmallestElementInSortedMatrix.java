import java.util.PriorityQueue;


// Time Complexity : Add : O(m*n), m-rows, n-columns
// Space Complexity : O(K), K - size of queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        kthSmallest(matrix, k);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b-a);  //maintaining a max heap for the largest elements will be removed
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                q.add(matrix[i][j]);
                int size = q.size();
                if(size>k){
                    q.poll();
                }
            }
        }

        return q.peek();

    }
}

