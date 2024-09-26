    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    Time Complexity for operators : o(klogk) .. k is the input
    Extra Space Complexity for operators : o(number of rows)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Iterate thru matrix and create array. sort it and return kth smallest element.
        # Optimized approach: 
                              
            # 1. 
                A) Creat Class as below to store indexs of element with the values
                            class elementvar{
                                int i;
                                int j;
                                int value;
                                
                                public elementvar(int i, int j,int value){
                                    this.i=i;
                                    this.j=j;
                                    this.value = value;
                                }
                            }
                B) then add all the first elements from the row.
                C) Check the top(min) element from queue and add next element from the matrix to the queue.
                D) Ietrate thru the matrix till (k-1)
                E) After above iterations, poll the top element which has our result value.
                F) At the end, return value.
        */

// min heap

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)
            return -1;
        
        PriorityQueue<elementvar> pq = new PriorityQueue<elementvar>((a,b) -> a.value - b.value);
        
        for(int i=0;i<matrix.length;i++){
            elementvar e = new elementvar(i,0,matrix[i][0]);
            pq.add(e);
        }
        
        for(int i=0;i<k-1;i++){
            elementvar e = pq.poll();
            // System.out.println(e.value);
            if(e.j+1 < matrix[0].length){
                elementvar e1 = new elementvar(e.i,e.j+1,matrix[e.i][e.j+1]);
                pq.add(e1);
            }
        }
        
        elementvar element = pq.poll();
        return element.value;
    }
}

class elementvar{
    int i;
    int j;
    int value;
    
    public elementvar(int i, int j,int value){
        this.i=i;
        this.j=j;
        this.value = value;
    }
}


// max heap with little change in the code

// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)
//             return -1;
        
//         PriorityQueue<elementvar> pq = new PriorityQueue<elementvar>((a,b) -> b.value - a.value);
        
//         for(int i=0;i<matrix.length;i++){
//             elementvar e = new elementvar(i,matrix.length-1,matrix[i][matrix.length-1]);
//             pq.add(e);
//         }
 
//         int val = (matrix.length * matrix[0].length) - k;
//         for(int i=0;i<val;i++){
//             elementvar e = pq.poll();
//             if(e.j-1 >= 0){
//                 elementvar e1 = new elementvar(e.i,e.j-1,matrix[e.i][e.j-1]);
//                 pq.add(e1);
//             }
//         }
        
//         elementvar element = pq.poll();
//         return element.value;
//     }
// }

// class elementvar{
//     int i;
//     int j;
//     int value;
    
//     public elementvar(int i, int j,int value){
//         this.i=i;
//         this.j=j;
//         this.value = value;
//     }
}