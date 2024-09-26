/**
 * Time Complexity:
 * O(Nlog(maxNumber - minNumber)) where N is tht total number of the elements in the matrix.
 *
 */
/**
 * Space Complexity:
 * The space complexity is O(1) as we are not creating any extra space.
 *
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class kthSmallestInMatrix {

    public int kthSmallestUsingHeaps(int[][] matrix, int k) {
        //to get kth smallest element, we can use a max heap of size k
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0 ;i < matrix.length; i++){
            for(int j = 0 ;j < matrix[0].length; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }

    int m,n;
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return -1;

        m=matrix.length;
        n=matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1];

        while (low < high) {
            int mid = low + (high-low)/2;
            System.out.println("mid : " + mid);
            int count = getCount(matrix, mid);
            if (count < k) {
                low = mid+1;
            }
            else {
                high = mid;
            }
            if (low == high) {
                return low;
            }
        }
        return low;
    }

    private int getCount(int[][] matrix, int mid) {
        int count=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (matrix[i][j] <= mid) {
                    count++;
                }
            }
        }

        return count;
    }

}
