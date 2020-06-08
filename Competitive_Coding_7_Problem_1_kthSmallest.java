import java.util.PriorityQueue;

//Time Complexity : O(n^2logn) (Where nXn is the dimension of the matrix )
//Space Complexity : n (Column of the matrix)
//Runs successfully on leetcode
//No problem

//Here we will be adding first column of matrix with element and it's index to the priority queue (Min Heap)
// We'll be popping elements k times. Each time with popping the element, we'll be adding the next element of that row to the priority queue
//After popping the queue k times, our element will be on the top of the queue



public class Competitive_Coding_7_Problem_1_kthSmallest {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {

            if(matrix == null || matrix.length == 0) return 0;

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.element,b.element));

            for(int i =0 ; i<matrix.length ; i++)
            {
                Pair np = new Pair(matrix[i][0],i,0);
                pq.add(np);
            }

            Pair out = new Pair(-1,-1,-1);
            while(k!=0)
            {
                out = pq.poll();
                if(out.column!=matrix[0].length - 1)
                {
                    pq.add(new Pair(matrix[out.row][out.column + 1],out.row,out.column + 1));
                }
                //System.out.println(out.element);
                k--;
            }

            return out.element;

        }
    }

    class Pair
    {
        int element;
        int row;
        int column;
        Pair(int element,int row,int column)
        {
            this.element = element;
            this.row = row;
            this.column = column;
        }
    }
}
