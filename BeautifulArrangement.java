// Time Complexity: Time Complexity: O(k), where "k" is the number of valid beautiful arrangements for a given value of "n.
// Space Complexity: O(n), where "n" is the value of the input parameter. The algorithm uses an additional boolean array of size "n+1" to mark visited numbers during backtracking. The recursive stack used for backtracking also contributes to the space complexity, but it remains bounded by "n."
// Explanation:  he countArrangement method calculates the number of beautiful arrangements of integers from 1 to "n" such that each number can be at a position "i" only if "i" is a multiple of the number or the number is a multiple of "i".
// The method uses backtracking to explore all possible arrangements, starting from position 1 to "n" and marking visited numbers to ensure no number is used more than once.

// The method keeps track of the count of beautiful arrangements in the variable "count," which is returned as the final result. The backtrack method recursively generates all valid arrangements and increments the count whenever a valid arrangement is found.
public class BeautifulArrangement {
    private int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pivot, boolean[] visited) {
        // base
        if (pivot > n) {
            count++;
            return;
        }

        // logic
        for (int i = 1; i <= n; i++) {
            // System.out.println("I: "+i);
            // System.out.println("pivot " + pivot);
            if (!visited[i] && (i % pivot == 0 || pivot % i == 0)) {
                visited[i] = true;
                // backtrack(n, pivot+1, visited);
                backtrack(n, pivot + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        int n = 4; // Replace with your desired value of n

        int count = beautifulArrangement.countArrangement(n);
        System.out.println("Number of beautiful arrangements for n = " + n + ": " + count);
    }
}
