
//Time Complexity: O(n*m*log(k))
//Space Complexity: O(k)

//we need to find the kth smallest element in the matrix
//we can use a max heap to store the k smallest elements.
//we iterate through the matrix and add each element to the max heap.
//if the size of the max heap exceeds k, we remove the largest element.
//at the end, the root of the max heap will be the kth smallest element.

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.add(mat[i][j]);
                if(pq.size()>k)
                    pq.poll();
            }
        }
        return pq.peek();
    }
}