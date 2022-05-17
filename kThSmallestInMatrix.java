/*
Problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/

// Approach 1: Using priority queue
class Solution {
    class Pos {
        int row;
        int col;
        
        Pos(int r, int c) {
            row = r;
            col = c;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        PriorityQueue<Pos> pq = new PriorityQueue<Pos>((p1, p2) -> matrix[p1.row][p1.col] - matrix[p2.row][p2.col]);
        
        for(int i = 0; i < Math.min(m, k); ++i) {
            pq.add(new Pos(i, 0));
        }
        
        int count = 0;
        int result = 0;
        
        while(!pq.isEmpty()) {
            Pos p = pq.poll();
            
            result = matrix[p.row][p.col];
            
            if(++count == k) {
                return result;
            }
            
            if(n > p.col+1) {
                pq.add(new Pos(p.row, p.col+1));
            }
        }
        
        return result;
    }
}

// Approach 2: Binary search - more efficient
class Solution {
    int n = 0;
    public int kthSmallest(int[][] matrix, int k) {
        n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            int countOfNumbersLessThanMid = getCount(matrix, mid);
            if (countOfNumbersLessThanMid < k) {
                low = mid + 1;
            } else {
                // if countOfNumbersLessThanMid >= k, we decrement high
                // In this case, if mid becomes 14, there are k elements in the matrix that are less than 14
                // But 14 itself is not in the matrix. So we decrement until we find 13 which is the answer in the matrix
                high = mid;
            }
        }
        return low;
    }
    
    private int getCount(int matrix[][], int target) {
        int count = 0;
        int j = matrix.length - 1;
        
        for (int i = 0; i < n; ++i) {
            while (j >= 0 && matrix[i][j] > target)
                --j;
            count += j + 1; // j is the index, we need count;
        }
        return count;
    }
}