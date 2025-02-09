
/**
 * Time Complexity: O(k) where k is number of arrangements
 * Space Complexity: O(N) for visited array
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * Iterate through numbers from 1 to n for each position pos.
 * Check if the current number i can be placed at pos:
 * Ensure i is not already visited.
 * Check if the number is "beautiful" by satisfying the condition:
 * i % pos == 0 (number is divisible by the position) OR
 * pos % i == 0 (position is divisible by the number)
 * If both conditions are satisfied:
 * Mark i as visited.
 * Recursively call recurse(n, pos + 1). Backtrack by unmarking i as visited.
 */

public class BeautifulArrangements {

    boolean[] visited;
    int count;

    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        count = 0;
        recurse(n, 1);
        return count;
    }

    private void recurse(int n, int pos) {
        // base
        if (pos > n) {
            count++;
            return;
        }

        // logic
        for (int i = 1; i <= n; i++) {
            // case 1 - if it is visited
            // and
            // case 2 - perm[i] is divisible by i || i is divisible by perm[i]
            if (!visited[i] && ((i % pos == 0) || (pos % i == 0))) {
                visited[i] = true;
                recurse(n, pos + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Your code here
        BeautifulArrangements obj = new BeautifulArrangements();
        int count = obj.countArrangement(5);
        System.out.println(count);
    }
}
