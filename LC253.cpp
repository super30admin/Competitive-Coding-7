
// Time complexity O(nlogn)
// Space complexity O(n)

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        std::sort(intervals.begin(), intervals.end(), [](const vector<int>& lhs, const vector<int>& rhs){
            return lhs[0] < rhs[0];
        });
        
        std::priority_queue<int, vector<int>, std::greater<int>> heap;
        for (int i = 0; i < intervals.size(); i++)
        {
            const auto& interval = intervals[i];
            if (heap.empty()) 
            {
                heap.push(interval[1]);
            }
            else
            {
                auto top = heap.top();
                if (interval[0] < top)
                {
                    heap.push(interval[1]);
                }
                else 
                {
                    heap.pop();
                    heap.push(interval[1]);
                }
            }
        }
        return heap.size();
    }
};