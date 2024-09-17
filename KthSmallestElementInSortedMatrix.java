//Time Complexity O(Log(n^2))
//Space Complexity O(1)
//LeetCode tested
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];int high = matrix[matrix.length-1][matrix.length-1];

        while(low<high){
            int mid = low+(high-low)/2;
            int count = countLessOrEqual(matrix,mid);
            if(count<k){
                low = mid+1;
            }else high = mid;
        }
        return low;
    }
    private int countLessOrEqual(int[][] matrix,int mid){
        int count = 0;
        int row = 0;int column = matrix.length-1;
        while(row<matrix.length && column>=0){
            if(matrix[row][column] <= mid){
                count += column+1;
                row++;
            }else{
                column--;
            }
        }
        return count;
    }
}
