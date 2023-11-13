#include<bits/stdc++.h>
using namespace std;

/*
Approach: BInary Search: Get the least value element such that there are k elements before that. low=mat[0][0], high=mat[m-1][n-1]. For counting elems less than x, iterate rows and columns as necessary.
Time: O(log(rangeOfElems) * (m+n))
Works on leetcode: yes 
*/

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int low=matrix[0][0];
        int high = matrix[matrix.size()-1][matrix[0].size()-1];

        while(low<high) {
            int mid = low + (high-low)/2;
            if(cntElemsLessThan(mid, matrix) >= k) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    int cntElemsLessThan(int val, vector<vector<int>>& matrix) {
        int m=matrix.size(), n=matrix[0].size();
        int cnt=0;
        for(int r=0; r<m; r++) {
            if(matrix[r][0] > val) {
                break;
            }
            else if(matrix[r][n-1] <= val) {
                cnt += n;
            }
            else {
                for(int c=0; c<n; c++) {
                    if(matrix[r][c]<=val) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
};

int main() {
    Solution S;
    
}