// Time Complexity : O(N^2) 

// Space Complexity : O(N) - maxHeap

// Did this code successfully run on Leetcode : YES

// Appoarch: Using maxHeap to store the min elements and pop the kth min.

// 378. Kth Smallest Element in a Sorted Matrix

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    // maxHeap
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        priority_queue<int> pq;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.push(matrix[i][j]);
                if(pq.size() > k){
                    pq.pop();
                }
            }
        }
       return pq.top(); 
    }
};