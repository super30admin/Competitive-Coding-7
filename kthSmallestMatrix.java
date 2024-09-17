// Time Complexity : O(n + nlogk)
// Space Complexity : O(n + k);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class kthSmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<matrix.length;i++){
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        k-=1;
        while(k!=0){
            int[] pop = pq.poll();
            k--;
            if(pop[2]+1<matrix.length){
                pq.add(new int[] {matrix[pop[1]][pop[2]+1], pop[1], pop[2]+1});
            }
        }
        return pq.poll()[0];
    }

    public static void main(String[] args){
        kthSmallestMatrix k = new kthSmallestMatrix();
        System.out.println(k.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
    }
}