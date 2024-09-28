# Time complexity:O(m*n)
# Space complexity: 0(m*n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No









class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval i : intervals) {
            if (!heap.isEmpty() && i.start >= heap.peek()) {
                heap.poll();
            }
            heap.offer(i.end);
        }
        return heap.size();
    }
}
