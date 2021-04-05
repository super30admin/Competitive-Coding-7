//TC: O(NlogN) for sorting the array. Heap insertion takes NlogK
//SC: O(N) since heap could at most consist of N meetings

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        
        priority_queue<int, vector<int>, greater<int>> minheap;
        
        
        if(intervals.size() == 0)
            return -1;

        //sort all the intervals
        sort(intervals.begin(), intervals.end());

      //check each pair of intervals
      for(auto pair:intervals){
        int start_time = pair[0];
        int end_time = pair[1];
    
        //if the heap size is not zero
        if(minheap.size() > 0){
          //check if the element in the minHeap has end time lesser than that of the start time of the new meeting. If yes, then this element can be removed since the new meeting can happen in the same room as the old meeting
          if(minheap.top() <= start_time){
            minheap.pop();
          }
        }
        
        //add the new meeting to the heap
        minheap.push(end_time);
      }
      
      //the answer is the size of the heap, i.e, all the rooms with clashing intervals.
      return minheap.size();

    }
};