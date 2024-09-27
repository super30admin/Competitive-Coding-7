import java.util.*;
/*******************************************Brute Force*****************************************/
//Time Complexity : O(m*n log m*n), m and n are rows and col respectively, log m*n is for sorting
//Space Complexity :O(m*n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Kth_Smallest_Element_ina_Sorted_Matrix_BruteForce {
	public int kthSmallest(int[][] matrix, int k) {
		int[] sorted = new int[matrix.length * matrix[0].length];
		int s=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				sorted[s] = matrix[i][j];            
				s++;
			}
		}
		Arrays.sort(sorted);
		return sorted[k-1];  
	}
}

/*******************************Using Priority Queue(Max heap)**********************************/
//Time Complexity :O(m * n log k),  m and n are rows and col respectively and for heapify it takes log k time
//Space Complexity :O(k), heap size
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class Kth_Smallest_Element_ina_Sorted_Matrix_PQ {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);	//max heap
		for(int i=0; i< matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				pq.add(matrix[i][j]);

				if(pq.size() > k)
					pq.poll();
			}
		}
		return pq.peek();
	}
}

/*******************************Using Binary Search**********************************/
//Time Complexity :O(m*n log k)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Kth_Smallest_Element_ina_Sorted_Matrix_BS {
	public int kthSmallest(int[][] matrix, int k) {
		int low = matrix[0][0];
		int high = matrix[matrix.length-1][matrix.length-1];
		while(low < high){
			int mid = low + (high - low)/2;
			int count = 0;
			for(int i=0; i<matrix.length;i++){
				for(int j=0; j<matrix[0].length;j++){
					if(matrix[i][j] <= mid)
						count++;	// count the number of elements less than mid
				}
			}
			if(count < k)	// if the count is less than k, then move the low pointer to mid+1
				low = mid +1;
			else
				high = mid;	// if the count is greater than k, then move the high pointer to mid

		}
		return low;	//	now both low and high will pointing at k, so return either of them
	}
}