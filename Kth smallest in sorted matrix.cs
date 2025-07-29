/*
  Time complexity: O(k*log m)
  Space complexity: O(m)
*/
public class Solution {
    public int KthSmallest(int[][] matrix, int k) {
        PriorityQueue<(int,int), int> pq = new();

        int m = matrix.Length;
        int n = matrix[0].Length;

        for(int i = 0;i<m;i++)
        {
            pq.Enqueue((i,0), matrix[i][0]);
        }

        int ans = 0;
        while(k-->0)
        {
                var temp = pq.Dequeue();
                int i = temp.Item1;
                int j = temp.Item2;

                ans = matrix[i][j];

                if(j+1<n)
                {
                    pq.Enqueue((i,j+1), matrix[i][j+1]);
                }
        }

        return ans;
    }
    
    
}
