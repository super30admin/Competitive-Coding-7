import java.util.*;

// Time Complexity : O(log N)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach


class Matrix {
    public int row,col,val;

    public Matrix(int row,int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }

}

public class KthSmallestSortedMatrix  {
    public int kthSmallestHeap(int matrix[][],int k){
        PriorityQueue<Matrix> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        int size = matrix[0].length;
        for(int i =0; i < size; i++){
            pq.add(new Matrix(0, i, matrix[0][i]));
        }
        int col = matrix[0].length;
        while(k  > 1){
            Matrix cell = pq.poll();
            int newRow = cell.row;
            int newCol = cell.col;
            if(newRow + 1  < col){
                pq.add(new Matrix(newRow + 1,newCol,matrix[newRow  +1][newCol]));
            }
            k--;
        }
        return pq.remove().val;
    }

    public int kthSmallest(int matrix[][],int k){
        if(matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length - 1;
        int low = matrix[0][0],high = matrix[row][row];

        while(low < high){
            int mid = low + (high - low)/2;
            int count = countLess(matrix, mid);
            if(count < k ){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public int countLess(int matrix[][],int ele){
        int i  =0,size = matrix.length;
        int result = 0,j = size -1 ;
        while(j >= 0 && i < size){
            if(matrix[i][j] > ele ){
                j--;
            }
            else {
                result += (j + 1);
                i++;
            }
        }
        return  result;
    }

    public static void main(String args[]){
        KthSmallestSortedMatrix smallest = new KthSmallestSortedMatrix();

        int matrix[][] = {{2,3,4,},{5,8,12},{13,15,29}};
        int  k = 8;
        System.out.println(smallest.kthSmallest(matrix, k));
        System.out.println(smallest.kthSmallestHeap(matrix, k));
        
    }
}
