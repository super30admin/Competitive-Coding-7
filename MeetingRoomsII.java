// Time complexity - O(n log n)
// space complexity - O(n)
// Solved on leet code - yes
// faced any issues - no
// Initially sorting all the start times, then we iterate through all the elements and add the end times to the Minheap. so the element which has minimum end time will always be at the top. so whenever the new element comes we can compare with that and replace it. This heap count gives the number of meeting rooms needed
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int[] a: intervals) {
            if(minHeap.isEmpty()) {
                minHeap.add(a[1]);
            } else {
                int topElement = minHeap.peek();
                if(a[0] >= topElement) {
                    minHeap.remove();
                    minHeap.add(a[1]);
                } else {
                    minHeap.add(a[1]);
                }
            }
        }
        return minHeap.size();
    }
}
