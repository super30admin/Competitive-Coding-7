// In this problem, we have sorted based on interval start time. We have a min heap to keep track of the end times of the meetings. 
// we iterate through the sorted intervals and for each interval we check if the min heap is not empty and the minimum end time is less than or equal to the start time of the current interval,
// if it is, we can remove the minimum end time from the heap because that meeting has ended and we can reuse that room for the current meeting.
// Time Complexity: O(n log n) because of the sorting step and the heap operations. 
//  Space Complexity: O(n) in the worst case when all meetings overlap and we need a room for each meeting.

class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        
   if (intervals.isEmpty()) return 0

        intervals.sortWith(compareBy { it[0] })

        val ends = PriorityQueue<Int>() // min-heap of end times

        for (m in intervals) {
            if (ends.isNotEmpty() && ends.peek() <= m[0]) ends.poll()
            ends.offer(m[1])
        }
        return ends.size

    }
}