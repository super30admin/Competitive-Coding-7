// Time - O(m*n)
// Space - O(k) 

// Add every element to the Priority Queue and if queue size exceeds k, remove the element from queue.
// Return the top element of queue.
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a); // max heap
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                q.add(matrix[i][j]); // add elements to max heap
                if(q.size() > k) {
                    q.remove(); 
                }
            }
        }
        return q.peek();
    }
}

// Binary Search Approach

// Time - O(mnlog(mn)) || Space - O(1)
// Use Binary search to calculate mid and then count the no of elements lesser than mid.
// If the count < k, move to the right else move to left
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        int low = matrix[0][0], high = matrix[m-1][n-1];
        while(low < high) {
            int mid = low+(high-low)/2;
            int count = 0;
            int j = n-1;
            for(int i=0;i<m;i++) {
                while(j>=0 && matrix[i][j]>mid) j--;
                count+=j+1;
            }
            if(count<k) low = mid+1;
            else high = mid;
        }
        return low;
    }
}