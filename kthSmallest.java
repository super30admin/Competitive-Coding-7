
public class kthSmallest {

	public int kthSmallestMatrix(int[][] matrix, int k) {
		
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int n = matrix.length - 1;
		int low = matrix[0][0];
		int high = matrix[n][n];
		
		while(low < high) {
			
			int mid = low + (high - low)/2;
			// calculate the count of the elements which are less than mid
			int count = getCount(matrix, mid);
			// since we need to find the kth smallest, if we find the count, we will know which direction to move ahead,
			// if count is less, we need ahead in matrix so that our count reaches k
			if(count < k)
				low = mid+1;
			else// if the count is greater, we will bring high near to mid so that our count reaches to k
				high = mid;
		}
		// return low/high value because that will be our matrix value when count becomes equal to k coz low will become equal to high
		return low;
	}
	
	public int getCount(int[][] matrix, int mid) {
		
		int len = matrix.length-1;
		int j = len;
		int count = 0;
		// calculate the count of values in matrix before mid, this will give us the lowest values count before mid.
		for(int i=0;i<=len;i++) {
			while(j>=0 && matrix[i][j] > mid)
				j--;
			// j will reach to our matrix index where our mid values are greater than matrix value., add that to count, 
			// since j is index, add 1 to it, to retrieve the count
			count += j+1;
		}
		return count;
	}
}
