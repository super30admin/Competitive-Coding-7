/* Using binary search, and taking the min and max element in the matrix, we do the following
 1. Get the middle element, 
 find the total number of elements which are less than or equal to this number in the matrix using function count_elem_less_than_num. 
The advantage is : that kth smallest numb which we are  trying to find is going to be at the point where we get the count 
from the function count_elem_less_than_num = our target.  
 If the total number of elements are more than what you searched for in matrix, 
it means you need to move your search window to the left to accomodate less elements. 
so the new search will be : start remains the same.end will change to mid. 
Here we are not changing to mid -1 because there can be a case where mid is the actual point where we get our target count elements. 
 If total number of elements is less than what you searched for in matrix, 
it means you need to increase your search window
 to do that... change start to mid + 1 and end remains the same so that we can get a higher window to search for
*/
// Time Complexity: O(klogk)    (where k = mn in the worst case)
    // Space Complexity: O(1)


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high){
            int mid = low+ (high -low)/2;
            int count = lessOrEqual(matrix, mid, n);
            if(count < k){
                low = mid +1;
            }
            else {
                high = mid;
            }
            
        }
        return low;
    }
    
        
        public int lessOrEqual(int[][]matrix, int mid, int n){
            int result =0;
            int j= n-1;
            for(int i=0;i<matrix.length;i++){
                while( j>=0 && matrix[i][j] > mid)
                    j--;
                    result += j+1;
               
            }
            return result;
        }

               
    
}


/*APPROACH 2:uSING min Heap */ 
// Time Complexity: O(klogk)    (where k = mn in the worst case)
    // Space Complexity: O(k)

class KthSmallestElementInSortedMatrix {
    
    
    
    public int kthSmallest(int[][] matrix, int k) {
        // Edge Case Checking
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0)
            return -1;
        
        int n = matrix.length;
        int m = matrix[0].length;
        // Creating a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Traverse through the matrix and add elements to the heap
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxHeap.add(matrix[i][j]);
                // If the heap size goes greater than k - remove the root element
                if(maxHeap.size() > k)
                    maxHeap.poll();
            }
        }

        // After the traversal - the root element will be the kth smallest element
        return maxHeap.peek();
    }
}