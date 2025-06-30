class Solution {
    class Element{
        int value ;
        int row;
        int col;

        Element(int value , int row , int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k){
        int m = matrix.length ; //number of rows
        int n = matrix[0].length ; //number of columns
        PriorityQueue<Element>heap = new PriorityQueue<>((a,b) -> a.value - b.value);

        //push first element of each row into heap
        for(int i = 0 ; i < m ; i++){
            heap.add(new Element(matrix[i][0] , i , 0));
        }
        int count = 0;
        int result = 0;

        while(!heap.isEmpty()){
            Element curr = heap.poll();
            result = curr.value;
            count++;
             if(count == k){
                break;
            }
            int nextColumn = curr.col + 1; // next column in the same row
            // Check if the next column is within bounds
            if (nextColumn < n) {
                // Add the element from the next column of the same row into the heap
                int nextValue = matrix[curr.row][nextColumn];
                heap.add(new Element(nextValue, curr.row, nextColumn));
            }
        }
        return result;



    }


}