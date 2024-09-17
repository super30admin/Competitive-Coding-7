/**Time Complexity: O(nlogn)
 * Space Complexity: O(n) where n is the number of meetings, in worst case every meeting would be overlapping
 * Executed on leetcode: yes
 * Approach: We sort the meetings first based on the start times
 * we create a min heap where we would be entering the end times
 * if the start date of say meeting 2 is less than the end time of meeting 1 (already in min heap), it means that both the meetings are overlapping
 * so we add meeting 2 in heap and keep it there. heapify will bring the meeting with the earliest end time and we need only this to compare with start time of next meeting
 * as the earliest end time meeting will end first and we can conduct new meeting after that and also due to the fact that if earliest end time meeting overlaps with start time of another meeting, we need not check the end times of meetings in the heap
 * 
 * we poll out the meeting which doesnt overlap as it doesnt need a separate room
 * at the end, the size of the heap represents all overlapping meetings which need separate rooms which is the result we return
 */


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0) return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;++i)
        {
            pq.add(intervals[i][1]);
            if(pq.peek()<=intervals[i][0]) pq.poll();
        }
        return pq.size();
        
    }
}