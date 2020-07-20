// Time Complexity :O(nlogn)
// Space Complexity :O(k) : worst case(O(n))
// Did this code successfully run on Leetcode :-
// Any problem you faced while coding this :-

// Your code here along with comments explaining your approach
//1. Sort wrt to the starting time
//2. Implement min heap and compare end_time with minimum element
//3. Return the size of priority queue as it is the number of rooms required.
bool sortcol( const vector<int>& v1,const vector<int>& v2 ) {
    return v1[0] < v2[0];
}

class Solution {
public:
    
    int minMeetingRooms(vector<vector<int>>& intervals) {
        //edge
        if(intervals.size()==0) return 0;
        
        sort(intervals.begin(), intervals.end(),sortcol);
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
        return (int)min_heap.size();
    }
        
    };
