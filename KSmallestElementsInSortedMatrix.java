// Approach : Binary Search and count the elements that are less than or equal to mid
// Time : O(N * log(max-min))
// Space : O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        int low = matrix[0][0];
        int high= matrix[n-1][n-1];
        while(low<high){
            int mid = low + (high -low)/2;
            int count = countLessEqual(matrix,mid);
            if(count<k){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    public int countLessEqual(int[][] matrix, int mid){
        int count =0;
        int j = matrix.length-1;
        for(int i =0;i<matrix.length;i++){
            while(j>=0 && matrix[i][j]>mid){
                j--;
            }
            count+=j+1;

        }

        return count;
    }
}

// Approach : Priority Queue using max heap
// Time : O(nlogk);
// Space : O(k)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a)); // Max Heap
       for(int i = 0;i<matrix.length;i++){
        for(int j =0;j<matrix[0].length;j++){
            pq.add(matrix[i][j]);
            if(pq.size()>k){
                pq.poll();
            }
        }
       }
       return pq.peek();
    }
}