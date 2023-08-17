//time O(nlogn)
//space O(n);

//Firstly we sort the 2-d vector according to the starting time, then
// we maintain a min heap to get the the earliest opening room and if the 
// end time is less than the start time, the room will be given to the next meeting.
//else, a new room will be created.

class Solution {
public:

    
        
    int minMeetingRooms(vector<vector<int>>& intervals) {

        
        sort(intervals.begin(), intervals.end(), []( vector<int>& a, vector<int>& b) {
            return a[0] < b[0];
        });
        priority_queue<int, vector<int>, greater<int>> pq;

        for(vector<int> interval:intervals){
            if(!pq.empty() && pq.top()<=interval[0]){
                
                pq.pop();
                pq.push(interval[1]);

            }
            else{
                pq.push(interval[1]);
                
                

            }
        }

        return pq.size();
    }
};