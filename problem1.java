//time: O(Nlog(N))
//space :(N)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (pq.peek() <= intervals[i][0])
                pq.poll();

            pq.add(intervals[i][1]);

        }

        return pq.size();
    }
}