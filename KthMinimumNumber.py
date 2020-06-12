#Time COmplexity : O(NLOGK) where N is number of elements and K is the number of elements in heap stack
#Space Complexity :O(K) where K is number of elements in stack 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     int i =0;
     int j = 0;
     int count = 0;
     PriorityQueue<Integer> pq = new PriorityQueue <> ((a,b)-> b -a);
     for (i = 0; i < matrix.length; i++)
     {
         for (j=0; j< matrix[0].length; j++)
         {
              pq.add(matrix[i][j]) ;   
              if (pq.size() > k)
              {
                  pq.poll();
              }
     }
     } 
    return pq.peek();
}
}