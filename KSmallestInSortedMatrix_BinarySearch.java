import java.util.Scanner;

public class KSmallestInSortedMatrix_BinarySearch {


        //BINARY SEARCH - NUMBER RANGE - O(N*log(Max - Min))

        int n;

        public int kthSmallest(int[][] matrix, int k) {

            n = matrix.length;

            // two ends of initial search range
            int begin = matrix[0][0]; int end = matrix[n-1][n-1];

            // Invariant
            while(begin < end) { // O(log(MAX - MIN))

                int mid = begin + (end - begin)/2;

                // count numbers in ascending left half to the mid
                int leftCount = leftHalfCount(matrix, mid); // O(N)

                // move search towards right if k is higher
                if(leftCount < k) begin = mid+1;

                    // move search towards left is k is smaller
                else end = mid;
            }

            //when coming out of above while loop, begin = end = mid
            // return begin is the same
            return end;
        }

        private int leftHalfCount(int[][] matrix, int mid) {


            // initial count of numbers in left half is zero
            int leftCount = 0;

            // iterate from left column towards right as rows are sorted
            for(int col = 0; col < n; col++) { // O(N)

                // start from bottom row
                int row = n - 1;

                // if element is greater than mid, check if the previous row is also greater than mid
                while(row >= 0 && matrix[row][col] > mid) {

                    //moving up on a column
                    row--;
                }
                /* whenever while loop finishes, element in row is not greater than mid. So, all elements up from that row in that column are also less than mid as columns are sorted*/
                leftCount += row+1;
            }

            // give left half count
            return leftCount;
        }

        public static void main(String[] args) {

            KSmallestInSortedMatrix_BinarySearch obj = new KSmallestInSortedMatrix_BinarySearch();

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

}


/*
TIME COMPLEXITY = O(N*log(MAX - MIN))

N = number of iterations to determine left half size

we will move N+N at max = all rows and columns = 2N = O(N)

Binary Search = log(MAX - MIN)

Total time complexity =  O(N*log(MAX - MIN))

SPACE COMPLEXITY = O(1)
*/