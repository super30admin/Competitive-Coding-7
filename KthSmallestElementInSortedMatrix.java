// O(n^2 log k) time, O(k) space
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

//         for (int[] nums : matrix) {
//             for (int num : nums) {
//                 pq.offer(num);

//                 if (pq.size() > k) {
//                     pq.poll();
//                 }
//             }
//         }
//         return pq.peek();
//     }
// }

// O(n * log(max - min)) time, O(1) space
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high-low)/2;

            int count = countLessEqual(matrix, mid, n);

            if (count < k) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    private int countLessEqual(int[][] matrix, int target, int n) {
        int count = 0;
        int row = n-1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row+1;
                col++;
            }
            else {
                row--;
            }
        }
        return count;
    }
}