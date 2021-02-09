
public class KthSmallestElementinaSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {

		int n = matrix.length;

		int low = matrix[0][0];
		int high = matrix[n - 1][n - 1];

		while (low < high) {

			int mid = low + (high - low) / 2;

			int count = getCount(matrix, mid);

			if (count < k) {
				low = mid + 1;
			} else {
				high = mid;
			}

		}

		return low;

	}

	private int getCount(int[][] matrix, int mid) {
		int count = 0;
		int length = matrix.length - 1;

		int j = length;

		for (int i = 0; i <= length; i++) {

			while (j >= 0 && matrix[i][j] > mid)
				j--;

			count += j + 1;
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
