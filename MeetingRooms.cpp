/*
Intuition: The idea here is to get the earliest meeting room.
This can be done by pushing the end times of the meeting rooms.

Time Complexity: O((N×log(N)))
Space Complexity: O(N)

*/
struct comparator{
    bool operator()(int v1, int v2){
        return v1 > v2;
    }
};
struct less_than_key
{
    inline bool operator() (vector<int> struct1, vector<int> struct2)
    {
        return (struct1[0] < struct2[0]);
    }
};
class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end(), less_than_key() );
        // for ( auto meet: meetings){
        //     cout<<meet<<endl;
        // }
        priority_queue <int, vector<int>, comparator> pq;

        for ( int i = 0; i < meetings.size(); i++){
            auto meeting = meetings[i];
            if ( i == 0){
                pq.push(meeting[1]);
            }
            else{
                int startingTime = meeting[0];
                int latestEndingTime = pq.top();
                if ( startingTime < latestEndingTime){
                    pq.push(meeting[1]);
                } 
                else{
                    pq.pop();
                    pq.push(meeting[1]);
                }
            }
        }
        return pq.size();
    }
};