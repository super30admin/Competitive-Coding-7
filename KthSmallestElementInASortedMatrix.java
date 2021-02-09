import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity :O(m*n log k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class KthSmallestElementInASortedMatrix {

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {

            int rows = matrix.length;
            int cols = matrix[0].length;

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            //using max heap and limit it to k values in max heap
            for(int i=0; i< rows; i++) {
                for(int j=0; j< cols; j++) {
                    maxHeap.add(matrix[i][j]);
                    if(maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }
            return maxHeap.poll();
        }
    }
}
