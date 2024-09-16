package S30.CompetitiveCoding_7;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Time Complexity : O(Nlogk), N is number of elements in matrix
Space Complexity : O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int R = matrix.length;
        if(R == 0) return -1;
        int C = matrix[0].length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){

            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){

                if(maxHeap.size() == 0) maxHeap.offer(matrix[i][j]);

                if(maxHeap.size() > 0 && matrix[i][j] < maxHeap.peek()){
                    maxHeap.offer(matrix[i][j]);
                }

                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();

    }
}
