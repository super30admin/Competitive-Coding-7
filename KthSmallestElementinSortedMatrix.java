//Time Complexity-O((n+m)logk)
//Space Complexity-O(n+m)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      if(matrix==null)  
      {
          return 0;
      }
        PriorityQueue<Integer>pQueue=new PriorityQueue(Comparator.reverseOrder());
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                pQueue.add(matrix[i][j]);
                if(pQueue.size()>k)
                {
                   pQueue.remove();
                }
            }
        }
        return pQueue.remove();
        
    }
}