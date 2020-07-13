#Time COmplexity : O(NLOGN) where N is number of elements and K is the number of elements in heap stack
#Space Complexity :O(N) where K is number of elements in stack 
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
=========================================================================================
#Time COmplexity : O(NLOGk) where N is number of elements and K is the number of elements in heap stack
#Space Complexity :O(K) where K is number of elements in stack 
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     int i =0;
     int j = 0;
     int count = 0;
     PriorityQueue<Integer> pq = new PriorityQueue <> ((a,b)-> (b-a));
     for (i = 0; i < matrix.length; i++)
     {
         for (j=0; j< matrix[0].length; j++)
         {
                 
              if (pq.size() < k)
              {
                  pq.add(matrix[i][j]) ;
                
              }
              else
              {
                  if (pq.peek() > matrix[i][j])
                  {
                      pq.poll();
                      pq.add(matrix[i][j]);
                      
                  }
              }
         }
     }
     
     return pq.peek();
}
} 
==================================================================================================
#Time COmplexity : O(KLogN) where N is number of elements AND K is number of Counts which is N in worst case
#Space Complexity :O(1) 
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        m = len(matrix[0])
        low = matrix[0][0]
        high = matrix[m-1][n-1]
        while(low < high):
            count = 0
            mid = low + (high-low)//2
            
            j = n-1
            for i in range(n):
                while(j>=0 and matrix[i][j] > mid):
                        j-=1
                count+= j+1
            if count < k:
                low = mid +1
            else:
                high = mid
        return low