// Time Complexity : n^2Logk
// Space Complexity : O(k), heap size of k 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Brute Force :
//Top element will be kth smallest element

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0; 
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
                if(pq.size() > k) {
                    pq.remove();
                }
            }
        } return pq.peek();     
    }
}


///////////////////////////

// Time Complexity : Nlog(max-min)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Binary Search
//Low = first element, high = last element
//find mid value = target to find using Binary Search (Binary Search in sorted matrix)
//see how many numbers are <= target in matrix (count)
//Kth number should be mid (k-1 numbers on left) and n-k numbers on right
//if count < k : then there are more than (n-k) numbers after mid, 
//so we inc target (make low = mid+1)
//if count > k, then more than (k-1) numbers before mid, 
//so we dec target  (make high = mid) (low < high)
//helperCount : we start searching from top right : sorted 
//row is increasing order; col is also increasing order
//so if mid >= matrix value (we move down (inc count)), 
//and count the number of elements less that the matrix value (col+1)
//do this till row < n or col >= 0
//if mid < matrix value, just decrease col 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high) {
            //find mid value to search in matrix
            int mid = low + (high - low)/2;
            //call the helper function 
            int count = helperCount(matrix, mid, n);
            //check which side to add elements (k-1, k , n-k)
            if(count < k) {
                //if less than k-1 elements on left side, increase target
                //by making low = mid+1
                low = mid + 1;
            }
            else {
                //if less than n-1 elements on right side, decrease target
                // by making high = mid
                high = mid;
            }
        }
        //return matrix value at low (kth smallest element)
        return low;       
    }
    
    //find count of numbers less than mid (target)
    //find number of elements <= mid (keep a count variable)
    public int helperCount(int[][] matrix, int mid, int n) {
        int row = 0;
        int col = n-1;
        int count = 0; 
        
        while(row < n && col >= 0) {
            if(matrix[row][col] <= mid) {
                count += col+1;
                row++;
            }
            else {
                col--;
            }
        }
        return count; 
    }
}

