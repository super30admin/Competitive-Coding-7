// Time Complexity: O(N×log(Max−Min))
// Space Complexity: O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0)
            return -1;
        int left=matrix[0][0];
        int n=matrix.length;
        int right=matrix[n-1][n-1];
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            int counter=(getcount(matrix,mid,n));
            if(counter<k)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
    public int getcount(int[][] matrix,int mid,int n)
    {
        int count=0;
        int c=n-1;
        for (int r = 0; r < n; r++) {
            while (c >= 0 && matrix[r][c] > mid)
                c--;
            count += (c + 1);
        }
        return count;
    }
}

/*
// Approach - Heap
// Runtime complexity - O(n + klogn)

class matrix_tuple {
    int x, y, val;
    public matrix_tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<matrix_tuple> pq = new PriorityQueue<matrix_tuple>((a,b)-> (a.val-b.val));
        for(int j = 0; j <= n-1; j++) pq.offer(new matrix_tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            matrix_tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new matrix_tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}
*/
