/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.*/


package LC378_KthSmallestinSortedMatrix;

import java.util.PriorityQueue;

public class LC378_KthSmallestinSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q= new PriorityQueue<>((a,b) -> (b-a));
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                q.add(matrix[i][j]);
                if(q.size() > k){
                    q.poll();
                }
            }
        }
        return q.poll();
    }

	public static void main(String[] args) {
		int[][] mat = { {1,2,3},{4,5,6},{7,8,9}};
		
		LC378_KthSmallestinSortedMatrix obj = new LC378_KthSmallestinSortedMatrix();
		System.out.println(obj.kthSmallest(mat, 7)); //Return 7th Smallest element
		// TODO Auto-generated method stub

	}

}
