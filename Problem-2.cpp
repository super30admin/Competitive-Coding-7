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
        sort(intervals.begin(), intervals.end(), cmp);
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
