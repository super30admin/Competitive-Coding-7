// Author: Subhed Chavan
// Batch: December 24
// Time Complexity: O(N!)
// Space Complexity: O(N)

class Solution {
    public:
        int result = 0;
    
        int countArrangement(int n) {
            // Base Case once
            if (n == 1) {
                return 1;
            }
    
            vector<bool> positions(n + 1, 0);
            recurse(n, 1, positions);
            return result;
        }
    
        void recurse(int n, int position, vector<bool> positions) {
            if (position > n) {
                result = result + 1;
                return;
            }
    
            for (int i = 1; i <= n; i++) {
                if (!positions[i] && (i % position == 0 || position % i == 0)) {
                    positions[i] = 1;
                    recurse(n, position + 1, positions);
                    positions[i] = 0;
                }
            }
        }
    };