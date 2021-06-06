import java.util.PriorityQueue;

// Time Complexity : nlog(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class KthSmallestinMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        
		PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> b-a);
        
		for(int i =0; i< matrix.length; i++){
			for(int j =0; j< matrix[0].length; j++){
				pq.add(matrix[i][j]);
				if(pq.size()>k)
					pq.remove();
			}
		}
		return pq.peek();
    }
    
}
