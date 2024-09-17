/*TC - O(klogN) + O(N) (heap construction +maintaning heap with subsequent elements)
 *SC - O(N)
 *
 * *
 /*Approach - Brute force */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // smallest elememt, max heap 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0 ; j< matrix[0].length; j++){
                pq.add(matrix[i][j]); 
                if (pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
        
    }
}




/*Approach 2 - optimized */
class Node{
    int val; 
    int r; 
    int c; 
    public Node(int val, int r, int c){
        this.val = val; 
        this.r = r; 
        this.c = c;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      // smallest element, min heap so we can pop the elements 
       // add all the rows's first element to the heap since its sorted, min(#rows, k) since we need only k elements to inspect
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val- b.val);
        for (int i = 0; i < k && i <  matrix.length; i++){
            Node node   = new Node(matrix[i][0], i, 0); // val, row, column
            pq.add(node);
        }
        int count = 0 ; 
         Node elem = null; 
        while(!pq.isEmpty()){
            // check if the popped node has further element in the row , if so add that to the heap
           
            elem = pq.poll();
            
            if (++count == k) break; // if the k smallest elements are found, break
            elem.c +=1 ;
            
            if (elem.c < matrix[0].length){
                Node newNode = new Node(matrix[elem.r][elem.c], elem.r,elem.c );
                pq.add(newNode);
            }
            
        }
        return elem.val;
    }      
        
}	

