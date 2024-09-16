
// Time: O(Log(N)) | Space: O(1)
// Binary Search Soln

class Solution {
    int m;
    int n;

    public int kthSmallest(int[][] matrix, int k) {
        m = matrix.length;
        n = matrix[0].length;
        // we keep the first and last value in the matrix as low and high
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        // we apply binary search on them
        while(low<=high) {
            // finding the mid w.r.t first and last element
            int mid = low+(high-low)/2;
            // counting how many elements that are closest to that mid
            int count = countLessThanMid(matrix, mid);
            // if count is less than given k,
            // we increase the low pointer
            if(count < k) {
                low = mid+1;
            } else {
                // else we keep reducing the high, to stop at mid
                high = mid-1;
            }
        }
        return low;
    }
    private int countLessThanMid(int[][] matrix, int mid) {
        int count = 0;
        // at every row,
        // we check the last element, if it is greater than mid,
        // if so, we add the entire column size to our count,
        // else we would still add the entire column size, additionally we perform traversal from last
        // to find out the element lesser than mid, meanwhile we will reduce the count
        for(int i=0;i<matrix.length;i++) {
            count+= n;
            if(matrix[i][n-1] > mid) {
                int j=n-1;
                while(j>=0 && matrix[i][j] > mid) {
                    count--;
                    j--;
                }
            }
        }
        return count;
    }
}

// Heap solution with K size heap
// Time: O(MN) | Space: O(K)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // max heap to have the k element sorted from max to min
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0;i<m*n;i++) {
            pq.add(matrix[i/m][i%n]);
            // once we have k elements,
            // we will keep adding the values,
            // and remove the max off the queue
            if(pq.size() > k) {
                pq.poll();
            }
        }
        // return the peek element
        return pq.peek();
    }
}

// Min heap soln,
// Time: O(K) | Space: O(Min(N, K))
class Solution {
    class HeapNode{
        int val;
        int row;
        int col;
        public HeapNode(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // min heap maintained for the size of Min(Matrix size, K)
        PriorityQueue<HeapNode> pq = new PriorityQueue<>((a,b) -> a.val -b.val);
        int N = matrix.length;
        int C = matrix[0].length;
        // to load all the first elements from each inner list, max size of heap would be K
        for(int i=0;i<Math.min(N, k);i++) {
            pq.add(new HeapNode(matrix[i][0], i, 0));
        }
        int kTimes = k-1;
        // we keep pulling out the min element and adding element next to it from that column
        // we perform this for k number of times
        // eventually, top of the queue we will have kth smallest
        while(kTimes > 0) {
            HeapNode top = pq.poll();
            int row = top.row;
            int col = top.col;
            if(col < matrix[row].length-1) {
                pq.add(new HeapNode(matrix[row][col+1], row, col+1));
            }
            kTimes--;
        }
        return pq.peek().val;
    }
}