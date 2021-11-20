/*
Time Complexity = O(nlogn)
Space Complexity = O(n)
where n is the total number of intervals in the vector.
*/
class Solution {
public:
    static bool cmp(vector<int> a, vector<int> b)
    {
        return a[0]<b[0];
    }
    int minMeetingRooms(vector<vector<int>> intervals) {
        sort(intervals.begin(), intervals.end(), cmp);                      //we are sorting the intervals on the basis of its starting time, so as when we insert the ending time of the meeting in the priority queue(min heap). As we compare the top of the priority queue with the next ending time of the meeting in the intervals.
        priority_queue<int, vector<int>, greater<int>> pq;
        for(auto interval : intervals){
            if(pq.size() > 0 && pq.top() <= interval[0]){
                pq.pop();
            }
            pq.push(interval[1]);
        }
        return pq.size();

    }
};
