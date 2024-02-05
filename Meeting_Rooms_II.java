// Time Complexity : O(nlogn) + O(nlogk)
// Space Complexity : O(k)
// Method used : Min heap

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int[] interval : intervals)
        {
            heap.add(interval[1]);

            if(interval[0] >= heap.peek())
            {
                heap.poll();
            } 
        }

        return heap.size();
    }
}