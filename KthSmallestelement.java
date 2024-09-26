
//Time Complexity : O(n log n) // heap log n for each element
//Space Complexity :O(k) // heap will hold at max k elements
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. Finding smallest element so will go with max heap by custom comparator
 * 2. add each element to heap and if size is more than k poll the element.
 * 3.return the top of the heap element as result.
 */

import java.util.PriorityQueue;
public class KthSmallestelement {
	public int kthSmallest(int[][] matrix, int k) {

		int n = matrix.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxHeap.add(matrix[i][j]);
				if (maxHeap.size() > k) {
					maxHeap.poll();
				}
			}
		}
		return maxHeap.poll();
	}
}
