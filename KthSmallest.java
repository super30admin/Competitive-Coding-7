//Time Complexity: O(N * log(Max−Min))
//In each iteration of our binary search approach, we iterate over the matrix trying to determine the size of the left-half. That takes O(N).
// Binary search space in terms of the minimum and the maximum numbers in the array: O(log(Max-Min))

//Space Compexity: O(1), no additional space for binary search
//Did it run successfully on leetcode: Yes
//Did you face any problem coding this challenge: No

class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];

        while(start < end) {
            int mid = start + (end - start) /2;
            // first number is the smallest and the second number is the largest
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};

            //no of elements lesser or equal to mid
            int count =  countLessThanEqualMid(matrix, mid, smallLargePair);

            if(count == k) return smallLargePair[0];
            if (count < k) start = smallLargePair[1]; // count is lesser so, increase mid, search higher
            else end = smallLargePair[0];  // count is larger, so, decrease mid, search lower

        }
        return start;
    }

    private int countLessThanEqualMid(int[][] matrix, int mid, int[] smallLargePair) {
        int row = matrix.length-1, col = 0;
        int count = 0;
        while(row >= 0 && col < matrix.length) {
            if(matrix[row][col] > mid)  {
                // as matrix[row][col] is bigger than the mid, calculate the smallest number greater than the mid to set boundaries for next iteration
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            }
            else {
                // as matrix[row][col] is less than or equal to the mid, calculate the biggest number less than or equal to the mid to set boundaries for next iteration
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}