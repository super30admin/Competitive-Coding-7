//Time Complexity: O(N*log(N-k)); where N is the total no. of elements in matrix.
//Space Complexity: O(N-k)
//Code run successfully on LeetCode.

public class Problem2_1 {

    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        
        for(int i =0; i <m; i++){
            
            for(int j =0; j <n; j++){
                
                pq.add(matrix[i][j]);
                if(pq.size() > m*n - k)
                    result = Math.max(result,pq.poll());            
            }
        }
        
        return result;
    }
}
