import java.util.PriorityQueue;

//Idea is to use Max heap to store K small elements in the heap so that top element 
// points to kth smallest element
//Time Complexity: O(n^2)
//Space Complexity: O(k)
public class kthsmallest {
        public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = matrix.length;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                }else{ 
                    if(matrix[i][j] < pq.peek()){ 
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        
        return pq.peek();
    }
}
