// space complexity = O(1)
// Time complexity = O(m*n * log(max value- min value))
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m-1][n-1];
        // binary search on the matrix-> max and min values.
        while(left< right) {
            int mid = left + (right-left)/2;
            if(count(matrix, mid)< k) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        // smallest number when right and left cross each other
        return left;
    }
    
    // determine the no. of elements that are less than or equal to the mid.
    private int count(int[][] matrix, int mid) {
        int j = matrix.length-1;
        int count=0;
        // the O(n) attached complexity.
        for(int i=0;i< matrix.length;i++) {
            while(j>=0 && matrix[i][j]> mid ) {
                j--;
            }
            count+=j+1;
        }
        return count;
    }
}

// solution brute force.
// used priority queue.
// Time complexity = O((m*n)log(m*n)) .
// Space complexity = O(k)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int i=0;i< matrix.length;i++) {
            for(int j=0;j< matrix[0].length;j++) {
                pq.add(matrix[i][j]);
                if(pq.size()>k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}