//Time Complexity : O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //brute force
    int minMeetingRooms(vector<vector<int>>& intervals) {
        if(intervals.size()==0) return 0;
        sort(intervals.begin(), intervals.end());
        vector<int> end_time;
        end_time.push_back(intervals[0][1]);
        
        //start from first element of intervals list
        for(int i=1; i<intervals.size(); i++){
            bool flag = true;
            int st_time = intervals[i][0];
            for(int j=0; j<end_time.size(); j++){
                if(st_time>=end_time[j]){
                    flag = false;
                    break;
                }
                    
                else{
                    flag = true;
                }
            }
            if(flag) end_time.push_back(intervals[i][1]);
            sort(end_time.begin(), end_time.end());
            else  
                end_time[0]=intervals[i][1];
        }
        
        return end_time.size();
    }
};