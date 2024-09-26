public class HelloWorld{
    // O(num of rows * log(num of rows) * log(mat[len][len]-mat[0][0]))
    public static int kthSmallest(int[][] mat, int k) {
        int l = mat[0][0]; int h = mat[mat.length-1][mat[0].length-1];
        // O(log(mat[len][len]-mat[0][0])) binary search between max and min val
        while(l<h){
            int mid = l + (h-l)/2;
            if (binary(mat, mid) < k){
                l = mid+1;
            } else {
                h = mid;
            }
        }
        return l;
    }
    
    
    // O(num of rows * log(num of rows)) to get count
    public static int binary(int[][] mat, int m) {
        int row = 0; int col = mat[0].length-1;
        int count = 0;
        while(row< mat.length && col>=0) {
            if(mat[row][col]<=m) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
    
    

     public static void main(String []args){
        int[][] mat = new int[][]{{1,5,9},{10,11,13}, {12,13,15}};
        System.out.println(kthSmallest(mat, 8));
     }
}