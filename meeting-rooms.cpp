//Tim - O(nlogn)
//Space - O(n)

class Solution {
public:
	int numberOfMeetingRooms(vector<pairs<int,int>> meetings){
		priority_queue<int, vector<int>, greater<int>> pq;
		if(meetings.size()==0 || meetings.size()==1) return meetings.size();

		sort(meetings.begin(),meetings.end());
		pq.push(meetings[0].second);

		for(int i=1;i<meetings.size();i++){
			if(meetings[i].first>=pq.top()){
				pq.pop();
			}
			pq.push(meetings[i].second);
		}

		return pq.size();
	}
}


