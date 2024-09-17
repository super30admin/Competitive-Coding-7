package CompetitiveCoding7;

import java.util.PriorityQueue;

public class kthSmallestElementInSortedMatrix {
    /* Created by palak on 8/8/2021 */

    /**
        Using Priority Queue
            Time Complexity: O(n log k)
            Space Complexity: O(n)
    */
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                //Adding negative values to the Priority Queue (which acts as a max heap for us)
                pq.add(-matrix[i][j]);
                if(pq.size() > k) {
                    pq.remove();
                }
            }
        }
        return -pq.peek();
    }

    /**
        Using Priority Queue
            Time Complexity: O(n log k)
            Space Complexity: O(n)
    */
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                pq.add(matrix[i][j]);
                if(pq.size() > k) {
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }


    class Triplets {
        int row;
        int col;
        int val;
        public Triplets(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    class Solution {
    /**
        Using Priority Queue
            Time Complexity: O(n log k)
            Space Complexity: O(n)
    */

        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Triplets> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

            //inserting first column
            for(int j = 0 ; j < matrix.length ; j++) {
                pq.add(new Triplets(j, 0, matrix[j][0]));
            }

            // Here, we will remove the element and add the next element in the same row but next column until the last column.
            for(int i = 0 ; i < k-1 ; i++) {
                Triplets temp = pq.remove();
                int col = temp.col;
                if(col == matrix[0].length - 1) {
                    continue;
                }
                System.out.println(matrix[temp.row][col + 1]);
                pq.add(new Triplets(temp.row, col + 1, matrix[temp.row][col + 1]));
            }
            return pq.poll().val;
        }
    }

/*
Priority Queue:
    1 -> 5 -> 9
    10 -> 11 -> 13
    12 -> 13 -> 15

    insert into heap:
    1 -> 10 -> 12 (size = 3) because we need to find 3rd smallest(example)
    1 -> 5 -> 10 -> 12 => 5 -> 10 -> 12
    Create a class with three values: row, col, element
    (10 + 10 + 20)
    1. how to insert element in PQ
    2. how do i compare elements while inserting them in PQ
    3. How do I insert elemnet of same row, if I remove the first element of that row?


    Binary Search: k = 8
    low = 1; high = 15; mid = 8 => count elemnts less than 8 in matrix => 2
    low = mid + 1;
    low = 9; high = 15; mid = 12 => count elemnts less than 8 in matrix => 6
    low = 10; high = 15; mid = 12
    low = 11; high = 15; mid = 13 => count elemnts less than 8 in matrix => 8 = k

    return mid(13);

    countElements() -> start from first row last column? Why?
    columnIndex - 0 + 1;
    Please be prepared - Request you to be available.
*/

    public static void main(String[] args) {

    }
}
