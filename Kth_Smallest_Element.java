// Time Complexity :- O(nlogk) or O(m*n) where m is the number of row and n is the number of columns in the matix. Kindly confirm.
//Space Complexity :- O(k)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->b-a);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                }                
                else{
                    if(matrix[i][j] < pq.peek()){ //15 < 13
                    pq.poll();
                    pq.add(matrix[i][j]);
                    }   
                }  
            }
        }
        return pq.poll(); //13
    }
} 