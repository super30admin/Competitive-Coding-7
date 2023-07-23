import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class KSmallestInSortedMatrix_BruteForce {

        // BRUTE FORCE - O(N^2)
        public int kthSmallest(int[][] matrix, int k) {

            List<Integer> li = new ArrayList<>(); // O(N*N) - Space

            for(int[] row: matrix) { // O(N*N)
                for(int num: row) {
                    li.add(num);
                }
            }

            Collections.sort(li); // O(N*logN)

            // return kth element in ascending sorted order
            return li.get(k-1);
        }

        public static void main(String[] args) {

            KSmallestInSortedMatrix_BruteForce obj = new KSmallestInSortedMatrix_BruteForce();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Size of the matrix: ");
            int n = scanner.nextInt();

            int[][] arr = new int[n][n];

            System.out.println("Sorted row&columned matrix:");

            for (int i = 0; i < n; i++) {

                System.out.println((i+1) + "th row: ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            System.out.print("K: ");
            int k = scanner.nextInt();

            int answer = obj.kthSmallest(arr, k);

            System.out.println("Kth smallest element in Sorted matrix is " + answer);
        }

/*
TIME COMPLEXITY = O(N*N)
SPACE COMPLEXITY = O(N*N)
*/
}
