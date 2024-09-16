// Time Complexity :m+n. O(log m+n), m = rows, n = colums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class KthSmallestElementInSortedMatrix {
    class Solution {
        int row;
        int col;
        public int kthSmallest(int[][] matrix, int k) {
            row = matrix.length;
            col = matrix[0].length;
            int low = matrix[0][0];
            int high = matrix[row-1][col-1];

            while(low < high) {
                int mid = low + (high - low) / 2;
                int[] arr = new int[]{matrix[0][0], matrix[row-1][col-1]};
                int count = getSmallerElements(matrix, mid, arr);
                if(count == k) {
                    return arr[0];
                } else if(count < k) {
                    low = arr[1];
                } else {
                    high = arr[0];
                }

            }
            return low;
        }

        private int getSmallerElements(int[][] matrix, int mid, int[] arr) {
            int count = 0;
            for(int r = 0 ; r< row; r++) {
                int c = col-1;
                for(; c>= 0; c--) {
                    if(mid < matrix[r][c] ) {
                        arr[1] = Math.min(arr[1], matrix[r][c]);
                        continue;
                    }else {
                        arr[0] = Math.max(arr[0], matrix[r][c]);
                        break;
                    }
                }
                count += c+1;
            }
            return count;
        }

    }
}
