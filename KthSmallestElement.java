// Time complexity - O(log n)
// Space complexity- O(1)
// Solved on leetcode - yes
// Did you face any issues - No
// Intially we are calculating the mid based on values in matrix, then finding out the count of leemnts less than mid.
// if the count is greater than the given k moves towards left, else we will be moving towards right. 
// The place where the left crosses right will be the point we are searching for in Binary search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for(int i =0;i<matrix.length;i++) {
        //     for(int j=0;j<matrix[0].length;j++) {
        //         minHeap.add(matrix[i][j]);
        //         if(minHeap.size() > (matrix.length * matrix[0].length) -k+1) {
        //             minHeap.remove();
        //         }
        //     }
        // }
        // return minHeap.peek();

        int low = matrix[0][0], n = matrix.length,m = matrix[0].length;
        int high = matrix[n-1][m-1];

        while(low<high) {
            int mid = low + (high-low)/2;
            int count = getCountOfElementsLesser(matrix, mid);
            if(count<k) {
                low = mid +1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int getCountOfElementsLesser(int[][] matrix, int target) {
        int count =0;
        int r = matrix.length-1, c=0;
        while(r>=0 && c<matrix[0].length){
            if(matrix[r][c]<=target) {
                count = count +(r+1);
                c++;
            } else {
                r--;
            }
        }
        return count;
    }
}
