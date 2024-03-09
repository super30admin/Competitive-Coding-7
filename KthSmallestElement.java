//T.C O(n log n)
//S.C O(n)
//LeetCode :   https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Use binary search to find mid value and check its position from the smallest,move the search window to find the kth smallest element
//and find the index
public class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
//Use binary search to see the mid element. Check the distance of mid from kth element,
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left<right){
            int mid = left + (right - left)/2;
            int count = getCount(matrix, mid); //If the position of mid is not k, move your search window
            if(count < k) left = mid + 1;
            else right = mid;
        }
        return left;

    }
    public int getCount(int[][] matrix, int mid){
        int count = 0, j = matrix.length - 1;
        for(int i=0;i<matrix.length;i++){
            while(j>=0 && matrix[i][j]>mid){
                j--;

            }
            count += j + 1; //count gives the position of mid from smallest

        }
        return count;
    }
}