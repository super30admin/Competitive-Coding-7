// Time Complexity : O(n log(maxEle - minEle)) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Thinking the approach that range should be considered

// Your code here along with comments explaining your approach

//Binary Search Approach
class Solution {
    
    private int countSmallerEle(int[][] matrix, int mid, int[] minMax) {
        //counting the number of elements lesser than mid
        int count = 0;
        int r=matrix.length-1;
        int c = 0;
        
        while(r>=0 && c<matrix.length) {
            if(matrix[r][c] <= mid){
                count += r+1;
                //element just before the mid
                minMax[0] = Math.max(matrix[r][c],minMax[0]);
                c++;
            } else {
                //element just after the mid
                minMax[1] = Math.min(matrix[r][c],minMax[1]);
                r--;
            }
        }
        
        return count;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return -1;
        
        int len = matrix.length;
        int start = matrix[0][0];
        int end = matrix[len-1][len-1];
        // finding mid of the values
        while(start<end){
            int mid = start + (end - start)/2;
            
            int[] minMax = new int[2];
            
            minMax[0] = start;
            minMax[1] = end;
            
            int count = countSmallerEle(matrix, mid, minMax);
            
            if(count == k){
                return minMax[0]; // kth smallest element
            } else if(count < k){
                start = minMax[1];
            } else {
                end = minMax[0];
            }
        }
        
        return start;
        
    }
}


//Priority Queue Approach
// Time Complexity : O(n + klog(n)) 
// Space Complexity : O(n)

class Solution {
    
    class minInteger{
        int value;
        int row;
        int column;
        
        minInteger(int val, int r, int c){
            value = val;
            row = r;
            column = c;
        }
        
        public int getValue(){
            return value;
        }
        
        public int getRow(){
            return row;
        }
        
        public int getCol(){
            return column;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return -1;
        
        int len = matrix.length;
        // min element is stored at the top
        PriorityQueue<minInteger> elements = new PriorityQueue<>(Math.min(k,len),
                                                             new Comparator<minInteger>(){
                                                                 public int compare(minInteger a, minInteger b){
                                                                     return a.getValue()-b.getValue();
                                                                 }
                                                             });

        // adding 1st column elements into the heap                                                     
        for(int i=0; i<Math.min(k,len); i++){
            elements.add(new minInteger(matrix[i][0],i,0));
        }
        
        minInteger ele = elements.peek();
        
        // removing the 1..k-1th min elements 
        while(k>0) {
            ele = elements.remove();
            int r = ele.getRow();
            int c = ele.getCol();
            if (c < len - 1) {
                elements.add(new minInteger(matrix[r][c+1],r,c+1));
            }
            k--;
        }
        //return kth min element
        return ele.getValue();
        
    }
}
