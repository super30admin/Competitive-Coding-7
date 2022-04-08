//Time  : n^2logn where n is number of rows
//space : o(n)
//Approach : Add all elemets in priority queue when size of queue become greater than k , poll

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        Queue<Integer> q = new PriorityQueue<>( (a,b) -> b -a);

        for(int i=0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length; j++){
                q.add(matrix[i][j]);
                if(q.size() > k ) q.poll();
            }
        }

     return q.peek();

    }


}
