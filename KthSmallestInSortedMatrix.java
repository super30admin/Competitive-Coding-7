import java.util.PriorityQueue;

//Time Complexity : O(N log k); where N= total number of elements in matrix
//Space Complexity : O(1)
public class KthSmallestInSortedMatrix {
	/**Approach1: Max Heap| Time O(N log k)| Space O(k)**/
	/*public int kthSmallest(int[][] matrix, int k) {
        //null check
        if(matrix==null || matrix.length==0) return -1;
        
        //max heap to store k elements from matrix
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b)-> b-a);        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }                
            }
        }        
        return pq.poll();
    }*/
	
	/**Approach2: Binary Search**/
	public int kthSmallest(int[][] matrix, int k) {
		//null check
        if(matrix==null || matrix.length==0) return -1;
        
        int n= matrix.length;         
        int low= matrix[0][0];
        int high= matrix[n-1][n-1];        
        while(low<high){ //O(log n)
            int mid= low+ (high-low)/2;
            
            int[] range= {matrix[0][0], matrix[n-1][n-1]};
            int count= countLeftElements(matrix, mid, range); //O(n)           
            if(count == k) 
                return range[0];
            else if (count<k)
                low= range[1]; //search in higher part
            else
                high= range[0]; // search in lower part
        }        
        return low;
    }    
    private int countLeftElements(int[][] matrix, int mid, int[] range){
        int count=0;
        //compare with last row and first column element
        int row= matrix.length-1;
        int col= 0;        
        while(row >=0 && col < matrix.length){
            if(mid < matrix[row][col]){
                range[1]= Math.min(range[1], matrix[row][col]);
                row--;
            }else{
                range[0]= Math.max(range[0], matrix[row][col]);
                col++;
                count+=row+1;
            }
        }        
        return count;
	}	
	
	
	// Driver code to test above
	public static void main (String[] args) {
		KthSmallestInSortedMatrix ob = new KthSmallestInSortedMatrix();	
		int[][] matrix= {{1,5,9},{10,11,13},{12,13,15}};
		int k=7;
		System.out.println(k+"th smallest element in matrix is: "+ob.kthSmallest(matrix, k));      
	}	
}
