// The time complexity of this implementation is O(n*2)
// The space complexity is O(1)
class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int left, right, mid, i, j;
        int n = matrix.length;
        left = matrix[0][0];
        right = matrix[n-1][n-1];
        while(left < right){
            mid = left + (right - left)/2;
            int count = 0;
            j = n-1;
            for (i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 4;
        KthSmallest sol = new KthSmallest();
        int result = sol.kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element in the matrix is: " + result);
    }

}