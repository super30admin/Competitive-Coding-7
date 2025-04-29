class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int left = matrix[0][0];
        int right = matrix[length-1][length-1];

        while(left < right){
            int mid = left +(right - left)/2;
            int count = count(matrix, mid);
            if(count < k)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }

    private int count(int[][] matrix, int mid){
        int count = 0;
        int j = matrix.length -1;
        for(int i=0; i<matrix.length; i++){
            while(j>=0 && matrix[i][j] > mid){
                j--;
            }
            count+=j+1;
        }
        return count;
    }
}