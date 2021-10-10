package CompetitiveCoding7;
//time complexity: M(rows)* log(x) where x is  (last - first) elements of the matrix
//space complexity : O(1)
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while (low <= high){
            int mid = (low + high) / 2;
            int count = getSmallElementsCount(matrix, mid);
//            if(count == k)
//                break;
            if(count < k){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
    private int getSmallElementsCount(int[][] matrix, int mid){
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //start from top right
        int row = 0;
        int col = n-1;
        while (row < m && col >= 0){

            if(mid < matrix[row][col] ){
                //move left
                col--;
            } else {
                //move down
                count += col+1;
                row++;

            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(new int[][] {{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(new int[][] {{1,2}, {1, 3}}, 3));
    }
}
