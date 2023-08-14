import java.util.PriorityQueue;

// Time Complexity : O(m) + O(k log k) -> O(k log k)
// O(m) is for inserting the values of first column
//O(k log k) is for heap -> k is the elements in heap.
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

public class KthSmallestElementUsingPQ {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);

        for(int i=0; i<m; i++)
        {
            pq.add(new int[]{matrix[i][0],i,0});
        }

        int[] temp = new int[2];
        while(k>0)
        {
            k--;
            temp = pq.poll();
            //temp[0] -> value
            //temp[1] -> row
            //temp[2] -> col
            if(temp[2]+1 >= n) continue;
            int nextVal = matrix[temp[1]][temp[2]+1];
            pq.add(new int[]{nextVal,temp[1],temp[2]+1});
        }

        return temp[0];

    }
}
