// Time Complexity:   O(n^n)
// Space Complexity:  O(n)

class Solution {
    boolean[] visited;
    int count = 0;
    public int countArrangement(int n) {
        visited = new boolean[n];
        countArrangement(n, 1);
        return count;
    }
    private void countArrangement(int n, int index) {
        // BASE
        if(index == n+1) {
            count++;
            return;
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i-1] && (i % index == 0 || index % i == 0)) {
                // ACTION
                visited[i-1] = true;
                // RECURSION
                countArrangement(n, index+1);
                //BACKTRACKING      
                visited[i-1] = false;                
            }
        }
    }
}


// // ******************** Another method ********************
// // Time Complexity:   O(n^n)
// // Space Complexity:  O(n)

// class Solution {
//     List<Integer> list;
//     int count = 0;
//     public int countArrangement(int n) {
//         list = new ArrayList<>();
//         for(int i=1; i<=n; i++) {
//             list.add(i);
//         }
//         countArrangement(n, 1);
//         return count;
//     }
//     private void countArrangement(int n, int index) {
//         // BASE
//         if(index == n+1) {
//             count++;
//             return;
//         }
        
//         for(int i=1; i<=list.size(); i++) {
//             // ACTION
//             int temp = list.remove(0);
//             if(temp % index == 0 || index % temp == 0)
//                 // RECURSION
//                 countArrangement(n, index+1);               
//             //BACKTRACKING      
//             list.add(temp); 
//         }
//     }
// }
