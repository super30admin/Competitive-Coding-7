/*
Time Complexity: O(k), where k is the valid permutation
Space Complexity: O(N), where N is the size of the boolean visited array
Run on leetcode: yes
Any difficulties: no

Approach:
1. I will be using backtracking to solve this problem, Will consider numbers till one by one and make beautiful arrangement
with that and will keep track of its count
 */
public class NBeautifulArrangements {
    public static int count = 0;
    public static int nBeautifulArrangement(int n){
        // Taking one boolean array to maintain if the position is already visited or not
        boolean[] visited = new boolean[n+1];
        // backtracking method

        backtrackMethod(n, 1, visited);
        return count;
    }

    public static void backtrackMethod(int n, int position, boolean[] visited){
        // Base Condition
        if(position>n){
            count++;
            return;
        }
        // iterate over the given number

        for(int i = 1; i<=n; i++) {
            if (!visited[i] && (position % i == 0 || i % position == 0)) {
                // action
                visited[i] = true;
                // recursion
                backtrackMethod(n, position + 1, visited);
                // backtrack
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("number of beautiful arrangements: "+nBeautifulArrangement(3));
    }
}
