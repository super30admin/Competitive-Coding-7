 // Time Complexity : O(n*logn)
// Space Complexity : O(n) in worst case. depending on count of clases the size of heap increases
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


 #include <iostream>
#include <vector>
#include<map>
#include<algorithm>

#include <queue>
using namespace std; 


bool sortcol( const vector<int>& v1, 
               const vector<int>& v2 ) { 
 return v1[0] < v2[0]; 
} 
 int minMeetingRooms(vector<vector<int>>& intervals) {
        //edge
        if(intervals.size()==0) return 0;
        
        sort(intervals.begin(), intervals.end());
        //logic
        priority_queue <int, vector<int>, greater<>> min_heap;
        min_heap.push(0);
        int i=0;
        while(!min_heap.empty() && i<intervals.size()){
            int temp = min_heap.top();
            if(temp<=intervals[i][0]){
                min_heap.pop();
            }
            min_heap.push(intervals[i][1]);
            i++;
        }
        return min_heap.size();
    }


    int main(){

        vector<vector<int>> intervals = {{1,2},{1,3}};

        int result = minMeetingRooms(intervals);

        cout<<result<<endl;
    }
