package competitiveCoding7;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	//Time Complexity : O(log n*m), where n are rows and m are columns
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = rank(matrix, mid);
            if(count < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
    
    private int rank(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int i = n-1, j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] > mid)
                i--;
            else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
    
	//Time Complexity : O(n*m log k), where n are rows and m are columns
	//Space Complexity : O(k), k is k
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size() > k)
                    maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }
	
	//Time Complexity : O(n*m log n*m), where n are rows and m are columns
	//Space Complexity : O(n*m), for elements in MaxHeap
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++)
                maxHeap.offer(matrix[i][j]);
        }
        
        while(maxHeap.size() > k)
            maxHeap.poll();
        
        return maxHeap.poll();
    }
}
