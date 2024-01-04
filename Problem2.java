/// Time Complexity :O (log(Max-Min)) where Min is the starting ppoint of the range of the values in the matrix and Max is the ending point.
// Space Complexity :O(1) no auxiliary data structure is used
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

import java.util.PriorityQueue;
public class Problem2 {

    //binary search
    public int kthSmallest(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int numberOfRows = matrix.length;
        int low = matrix[0][0];
        int high = matrix[numberOfRows-1][numberOfRows-1];


        while(low<high){
            int mid = low + (high-low)/2;
            int[] smallLargePair = {matrix[0][0], matrix[numberOfRows - 1][numberOfRows - 1]};

            int leftCount = getCountOfNumbersLessThanOrEqual(matrix, mid, smallLargePair);
            if(leftCount == k){
                return smallLargePair[0];
            }else if(leftCount > k){
                //reject right/later half
                high = smallLargePair[0];
            }else{
                //reject left half
                low = smallLargePair[1];
            }
        }
        return low;
    }

    private int getCountOfNumbersLessThanOrEqual(int[][] matrix, int mid, int[] smallLargePair){

        int n = matrix.length;
        int rowIndex = n-1;
        int colIndex = 0;
        int resultCount = 0;

        while(rowIndex >= 0 && colIndex < n){
            if(matrix[rowIndex][colIndex] > mid){
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[rowIndex][colIndex]); //smallest number present in the matrix > mid
                rowIndex--;
            }else{
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[rowIndex][colIndex]); //largest number present in the matrix <= mid
                resultCount += rowIndex +1;
                colIndex++;
            }
        }
        return resultCount;
    }



    //Heap solution
    //Time complexity : O(min(k, n)) + O(k * (log(min(n,k)) where n is the number of rows in the matrix
    //Space complexity: O(min(n,k)) - for the heap

    private class Cell{
        private int rowIndex;
        private int colIndex;
        private int value;

        public Cell(int row, int col, int val){
            this.rowIndex = row;
            this.colIndex = col;
            this.value = val;
        }
    }


    public int kthSmallestUsingHeap(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int minHeapSize = Math.min(matrix.length, k);
        //initially add the first element of each row
        int col = 0;
        for(int row=0; row<minHeapSize; row++){
            Cell newCell = new Cell(row, col, matrix[row][col]);
            minHeap.add(newCell);
        }

        //now traverse k times
        Cell top = minHeap.peek();
        while(k>0 && !minHeap.isEmpty()){
            top = minHeap.poll();
            if(top.colIndex != matrix.length-1){
                Cell nextCell = new Cell(top.rowIndex, top.colIndex + 1, matrix[top.rowIndex][top.colIndex + 1]);
                minHeap.add(nextCell);
            }
            k--;
        }
        return top.value;
    }
}
