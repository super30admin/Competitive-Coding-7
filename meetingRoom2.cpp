class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        
        if (intervals.size()==0) { //sanity check
            return 0;
        }
        vector<int> start,endt;
        
        for (int i=0;i<intervals.size();i++) {
            start.push_back(intervals[i][0]);
            endt.push_back(intervals[i][1]);
        }
        
        sort(start.begin(),start.end());
        sort(endt.begin(),endt.end());
        
        multimap<int,char> mm;
        
        for (int i=0;i<start.size();i++) {
            mm.insert({start[i],'a'});
            mm.insert({endt[i],'e'});
        }
        
        int count=0;
        int maxi=1;
        
        for (auto x:mm) {
            if (x.second=='a') {
                count++;
                maxi=max(maxi,count);
            } else {
                count--;
            }
        }
        
        return maxi;
    }
};