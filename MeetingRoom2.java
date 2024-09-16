//Sorting+Heap solns

// Time: O(NLogN)+O(NLogK) | Space: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sorting upon the start time of intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        // min heap to maintain the order end time that can not be combined with any other meeting intervals
        PriorityQueue<Integer> unmergableEndTimes = new PriorityQueue<>((a,b) -> a-b);
        // keep adding to the queue, and remove when the current interval's startTime is greater than the end time from the top of the queue
        // remove that, add current interval's end time to the heap
        for(int i =0;i<intervals.length;i++) {
            if(i > 0) {
                if(intervals[i][0] >= unmergableEndTimes.peek()) {
                    unmergableEndTimes.poll();
                }
            }
            unmergableEndTimes.add(intervals[i][1]);
        }
        return unmergableEndTimes.size();
    }
}

// List with heap soln
//Time: O(NLogK) + O(N*(N+logK(for heapification post polling))) - worst case if no meettings can be combined - Space: O(N)+O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // pushing the values to heap as per the start time
        for(int i=0;i<intervals.length;i++) {
            pq.add(intervals[i]);
        }
        List<int[]> list = new ArrayList<>();
        int count = 0;
        while(!pq.isEmpty()) {
            int[] currMeetingInterval = pq.poll();
            for(int i=0;i<list.size();i++) { // O(N)
                int[] curr= list.get(i);
                // when meetings can be combined, removing the earlier slot
                if(currMeetingInterval[0] >= curr[1]) {
                    list.remove(i);
                    break;
                }
            }
            list.add(currMeetingInterval);
        }
        return list.size();
    }
}