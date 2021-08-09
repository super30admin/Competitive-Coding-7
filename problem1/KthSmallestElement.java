//Time Complexity : O(mnlogk), m -> Number of rows, n -> Number of columns
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.PriorityQueue;

public class KthSmallestElement {
	public int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				queue.add(matrix[i][j]);
				if (queue.size() > k) {
					queue.poll();
				}
			}
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		KthSmallestElement obj = new KthSmallestElement();
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 8;

		System.out.println(k + "th smallest element in the matrix: " + obj.kthSmallest(matrix, k));
	}

}
