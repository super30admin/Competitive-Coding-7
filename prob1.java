class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];  // To track visited numbers
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {  // Base case: If all positions are filled
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) { 
                visited[i] = true;  // Mark number as used
                backtrack(n, pos + 1, visited);
                visited[i] = false;  // Backtrack
            }
        }
    }
}