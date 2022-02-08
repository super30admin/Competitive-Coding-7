/**
 * Time Complexity:
 * O(Nlogm) where m is the number of possible meeting rooms and N is the number of elements given
 * 
 */


/**
 * @brief Space Complexity:
 * The space complexity is O(N)
 */

/**
 * Approach:
 * We are using the heaps to soleve this problem as with brute force we will
 * have nested loops and it will impact the time complexity. We are taking
 * inimum heap here. We go through all the intervals and compare the top element 
 * in the heap with the starting time of the interval. If the top less than or equal to 
 * the top element we pop the element at the top. Otherwise we store the intervals
 * second element in the heap and heapify takes place which sends the minimum time to the
 * top.
 */


// The code ran perfectly on leetcode.


class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for(auto interval : intervals)
        {
            if(!pq.empty() && pq.top() <= interval[0] ){
                pq.pop();
            }
            pq.push(interval[1]);
        } 
        return pq.size();
    }
};