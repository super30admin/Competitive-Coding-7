// time complexity = O(nlog(n))
// space complexity = O(nlog(n))
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // the reason we sort the array is because we need to take care of the
        // start times, so start1, start2, start3 are in order.
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        // logic
        // start1< end1< start2< end2
        // use minheap
        // the reason for using minheap is that the end1 is compared to incoming element start2 , and the minheap is because we need to push the smallest end2 in the heap.
        // so when a larger element with start2 and end2 comes in as incoming element, we can use the min element in the pq to be compared with start2.
        PriorityQueue<Integer> pq = new PriorityQueue<>();// 10,20,30
        pq.add(intervals[0][1]);
        for(int i=1;i< intervals.length;i++) {
            if(pq.peek() <= intervals[i][0]  ) {// end1 < start2 
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        System.out.println(pq);
        return pq.size();
    }
}