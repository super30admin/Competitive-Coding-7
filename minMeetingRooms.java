// Time Complexity : O(nlogn)
// Space Complexity : O(n)
//Leetcode problem: https://leetcode.com/problems/meeting-rooms-ii/

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            if(q.peek() <= intervals[i][0]){
                q.poll();
            }
            q.offer(intervals[i][1]);
        }

        return q.size();
    }
} 