import java.util.PriorityQueue;

public class KthSmallest {

    // Max heap approach
    // TC: O(n^2 * log k)
    // SC: O(k)
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }

    // Priority queue with level order traversal
    // TC: O(k * log n)
    // SC: O(n)
        // n - number of rows in a matrix
        // k - input we get
    public int kthSmallest2(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return -1;

        // We will be storing the co-ordinates into the map
        // Min heap sorting will be based on the element at that co-ordinate
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);

        // First put the first element of each row into the queue
        // Each element represents the base address. We can find the next elements in its row.
        for(int i=0; i < matrix.length; i++) {
            pq.add(new int[]{i,0});
        }

        while(k > 0) {
            int[] current = pq.poll();
            k--;

            if(k==0) return matrix[current[0]][current[1]];

            // Check whether the next column we'll be calculating is within the bounds or not
            if(current[1] + 1 < matrix[0].length){
                pq.add(new int[]{current[0], current[1]});
            }
        }

        return -1;
    }
}
