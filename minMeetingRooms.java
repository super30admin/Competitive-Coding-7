// Time Complexity: O(NlogN)
// Space Complexity: O(N)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        heap.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++)
        {
            int temp=heap.peek();
            if(intervals[i][0]<temp)
            {
                heap.add(intervals[i][1]);
            }
        }
        return heap.size();
    }
}
