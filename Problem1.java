import java.util.PriorityQueue;

/*
/kth-smallest-element-in-a-sorted-matrix/
approach: add the minimum elements in all rows to priority queue. now traverse from 1 to k on the pq and add ith smallest
element to pq.
 */
public class Problem1 {
//    time: O(k log k)
//    space: O(k)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[0]-b[0]));

        for(int i=0;i<matrix.length;i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        int j = 0;
        int ans = -1;
        while(j<k) {
            int[] top = pq.poll();
            int r = top[1], c = top[2]; ans = top[0];
            if(c!=matrix[0].length-1) pq.add(new int[]{matrix[r][c+1], r, c+1});
            j++;
        }

        return ans;
    }

    //time: (mxn) log (max in matrix-min in matrix)
    // space: O(1)
//    approach: first consider the max and min in given matrix which are m[rows][cols] and m[0][0] as it is sorted matrix;
//    now do binary search to find (minimum value mid) for which count of elements<=mid are >=k;
    public int kthSmallestBinary(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], h = matrix[m-1][n-1];
        int ans = -1;
        while(l<=h) {
            int mid = l+(h-l)/2;

            if(count(matrix, mid)>=k) {
                ans = mid;
                h = mid-1;
            }
            else l = mid+1;
        }

        return ans;
    }

    private int count(int[][] matrix, int t) {
        int count = 0, col = matrix[0].length-1;
        for(int i=0;i<matrix.length;i++) {
            while(col>=0 && matrix[i][col]>t) col--;
            count+=col+1;
            col = matrix[0].length-1;
        }

        return count;
    }
}
