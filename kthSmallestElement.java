// Time Complexity : O(nlogK) where n is the number of elements in the 2-3 matrix  
// Space Complexity :O(K)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


import java.util.*;

class cc7{

public static int kthSmallest(int[][] matrix, int k) {

		//priority queue to implement maxheap
		PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a); 
		int n = matrix.length;
		int m = matrix[0].length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				//to keep the time complexity to n log k we don't need to insert elements greater than the root element in the heap when heap is at
				//size k
				if(heap.size()>k && heap.peek() > matrix[i][j])
				{
					heap.poll();
					heap.add(matrix[i][j]);
				}
				//keep inserting elemnts to the heap when heap size is less than k
				else if(heap.size()<k)
				{
					heap.add(matrix[i][j]);
				}
				

				
			}
		}
		int ans = heap.peek();
		System.out.println("kth smallest elemtn is "+ans);
		return ans;
    }

public static void main(String[] args)
{

	int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
	int k = 8;
	kthSmallest(matrix,k);

}

}