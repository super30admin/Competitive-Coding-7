//TC = O(M*N)
//SC = O(k)

import java.util.*;
public class KthSmallestElement
{
    public static int KthSmallest(int[][] matrix, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0;i<matrix.length;i++)
        {
            for(int j =0;j<matrix[0].length;j++)
            {
                pq.add(matrix[i][j]);

                if(pq.size()>k)
                {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }


    public static void main(String args[])
    {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(KthSmallest(matrix, 8));
    }
}