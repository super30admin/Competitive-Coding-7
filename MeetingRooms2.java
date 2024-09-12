// TC: O(logn)
// SC: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int i = 0; i < intervals.length; i++) {
            if(pq.isEmpty()) {
                pq.add(intervals[i]);
            } else {
                int[] curr = intervals[i];
                int[] prev = pq.poll();
                if(prev[1] <= curr[0]) {
                    prev[1] = curr[1];
                    pq.add(prev);
                } else {
                    pq.add(prev);
                    pq.add(curr);
                }
            }
        }
        return pq.size();
    }
}