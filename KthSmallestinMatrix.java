// Time Complexity : O(n*m) 
// Space Complexity : O(k), there are only at max k elements in heap/queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//initialized a priorityqueue with maxheap property
//we shall traverse through matrix and place elements in queue
//when the queue size is greater than k, then pop the element
//return the top element after all elements in matrix have been traversed.
//when heap size is greater than k, all the lements greater than our required kth smallest will be removed.
//so the top element after the loop would be our desired kth smallest.


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return -1;
        PriorityQueue<Integer> res=new PriorityQueue<>((a,b)-> b-a);
        int n=matrix.length*matrix[0].length;
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    res.add(matrix[i][j]);
                    if(res.size()>k){
                        res.remove();
                    }
                }
                
            }
        return res.peek();
        }
        
        }