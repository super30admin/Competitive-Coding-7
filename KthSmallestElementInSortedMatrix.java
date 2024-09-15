//Problem 95 : Kth Smallest Element in a Sorted Matrix
//TC: O(n*log(max-min))-> max-min is the search space and n is Max(row,col) when counting elements
//SC: O(1)


/*Steps

  1) Bruteforce : TC: O(nlogn), n stands for rows*cols| SC:O(row*col). Copy all the elements in a new list, sort that list and return k-1 element as that will be the kth smallest.
  
  2) Optimised: 1) TC:O(nlogK) | SC:O(1). Using Max Heap

                2) Using Binary Search : TC:O(n*log(max-min))-> max-min is the search space and n is Max(row,col) when counting elements
                The key point for any binary search is to figure out search space. There are two kinds of search space: index and range. Usually, when the array is sorted in one direction, we can use index as search space; otherwise, we use values as our search space.
                As here matrix is sorted in two directions, we will be using values for our search space
                Consider 'start' as min value and 'end' as max value. Then find the mid. Once u get the mid count number of values lesser than or equal to the mid.
                If count >=k , the u have to decrease the search space and thus move end pointer to mid-1 else if count<k, means u have to increase the search space and thus move start to mid+1; 
                Finally when end becomes lesser than the start return start.

                For counting values use the similar concept of search in 2matrix II, start from first row and last column.
                If current element value is less than or equal to the mid just add col index + 1 to the count and increment the row index, othewise decrement the col index;


*/
//Binary Search
class Solution94 {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix==null || matrix.length==0) return 0;
        
        //TC:O(n*log(max-min))-> max-min is the search space and n is Max(row,col) when counting elemnts
        //SC:O(1)
        
        int start = matrix[0][0];
        int end   = matrix[matrix.length-1][matrix[0].length-1];
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            int countValues = countValues(matrix,mid);
            
            if(countValues>=k){//decrease the search space by moving end pointer towards mid-1
                end = mid-1;
            }else{//countvalues<k -> here we got less values than k, that means we have to increase our search space and then  move start pointer towards mid +1;
                start = mid+1;
            }
            
        }
        
        return start;
        
    }
    
    //Just like Search in 2dMatrix-2 because row and column both are sorted. Start from first row last column and check if that element is smaller, just add column index+1 to the count
    private int countValues(int[][] matrix, int mid){
        
        int count = 0;
        int row   = 0;
        int col   = matrix.length-1;//because it is n*n matrix
        
        //as row and columns are both sorted and it is n*n matrix
        while(row<matrix.length && col>=0){
            
            if(matrix[row][col]<=mid){
                count += col+1;//because we need number of element smaller than or equal to current col and col index starts from 0 i.e col+1; 
                row++;
            }else{
                col--;
            }
            
        }
        
        return count;
    }
    
}


//Using Heap
/*
import java.util.*;
class SolutionUsingHeap {
    public int kthSmallest(int[][] matrix, int k) {
        
        //edge
        if(matrix==null || matrix.length==0) return 0;
        
        //max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        //traversal over array
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                maxHeap.add(matrix[i][j]);
                
                if(maxHeap.size()>k){
                    maxHeap.poll();
                }
                
            }
        }
        
        return maxHeap.peek();
        
    }
    
}*/