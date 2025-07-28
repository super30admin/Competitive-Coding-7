// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Time Complexity : O(nlog(range))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// we can use maxheap pf size k. then at the end top element will be kth smallest.
// we are using binary search in range of least and largest number in matrix, cause
// kth smallest will be present in it. now for evey mid, we check how many
// elements are lesser than or eqaul to mid. if it more than k, we decrease high else we
// increase low.

// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
//         int n=matrix.length;
//         for(int i =0; i<n;i++){
//             for(int j=0;j<n;j++){
//                 int num = matrix[i][j];
//                 pq.add(num);
//                 if(pq.size()>k)pq.poll();
//             }
//         }
//         return pq.peek();
//     }
// }

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high=matrix[n-1][n-1];
        while(low<high){
            int mid = low + (high-low)/2;
            int c = order(mid, matrix);
            if(c<k) low=mid+1;
            else high=mid;
        }
        return low;
    }
    private int order(int val, int[][]matrix){
        int n = matrix.length;
        int count =0;
        int row=n-1;
        int column=0;
        while(row>=0 && column<n){
            if(matrix[row][column]<=val){
                count+=row+1;
                column++;
            }else{
                row--;
            }
        }
        return count;
    }
}
