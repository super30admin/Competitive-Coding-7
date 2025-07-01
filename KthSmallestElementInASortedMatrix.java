//time complexity- O(n^2 log k)
//space complexity- O(k)
import java.util.*;
public class KthSmallestElementInASortedMatrix {
    static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int total = n * n;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                q.offer(matrix[i][j]);
                if(q.size() > k) q.poll();
            }
        }
        return  q.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;

        System.out.println(k + "th smallest element in a sorted matrix is: " + kthSmallest(matrix, k));
    }
}
