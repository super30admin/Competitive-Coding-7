// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*Approach
1) in this we have a sorted matrix, and hence we can use binary search to find out the the Kth smallest element.
2) Thus we use 2 combinations for this
3) we apply binary search on elements and not indices
-> we keep low / left to element at 0,0 i.e. matrix[0][0]
and keep high /right to element at matrix[matrix.length-1][matrix[0].length-1]

and now we collect the mid
-> 
4) Now most important step, we get the rank of the element occuring, through which we can shift our left and right
-> we start from last row and 1st column or start from 1st row and last column
-> we find the mid and if the current element (last row & first column) is greater than the mid, thus we know we have crossed the bounds for the Kth element and we decrement the row
-> otherwise we increment the count+=count + ith row + 1;(count indicates the positions which we are from k) && we add ith row as we would add all(number of) elements present in the row
and we increment the columns

5) if the count obtained is count <k
-> then we continue our binary search but increase our low 
-> else decrement the high

*/

class KthSmallestUsingBinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        
      // using binary search for finding the kth smallest element
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        
        while(left<right)
        {
            int mid = left+(right-left)/2;
            int count = getCount(matrix,mid);
            
            if(count<k)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
            
        }
        
        return left;
    }
    
    public int getCount(int [][]matrix, int target)
    {
        int count =0;
        int j=matrix.length-1;
        
        for(int i=0;i<matrix.length;i++)
        {
            while(j>=0 && matrix[i][j]>target)
            {
                j--; // decrement the column
            }
            count+=j+1; // we add the number of elements like we had 1,2,3 in first row. our i=0 and j is at 3
            // if matrix[i][j]>target, target is suppose 1
            // thus we decrement j and move to previous column
            // but that affects the count, thus we add j as is we added 3 elements to count and then we would decrement.
            
        }
        
        return count;
    }
}