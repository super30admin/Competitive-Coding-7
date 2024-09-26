// Time Complexity : O(n logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Sort the start of each meeting.
//Add the end of each meeting in min heap
//Now traverse through the sorted array and check if its less than the min heap value
//Keep the count of number of values traversed before each heap poll
//The maximum among these would be our answer
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] sortedStart = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            sortedStart[i] = intervals[i][0];
            pq.add(intervals[i][1]);
        }
        Arrays.sort(sortedStart);
        int maxCount = 0;
        int minEnd = pq.poll();
        int ans = 0;
        for(int i = 0; i < n; i++){
            while(i < n && sortedStart[i] < minEnd ){
                maxCount++;
                i++;
            }
            if(maxCount > ans)
                ans = maxCount;
            if(!pq.isEmpty()){
                minEnd = pq.poll();
                maxCount--;
                i--;
            }
        }
        return ans;
    }
}