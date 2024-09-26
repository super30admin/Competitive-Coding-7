



// Time  - O(N Log N)
// Space - O(N)



class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0) return 0;

        // sort the priority queue based on ascending order
        PriorityQueue<Integer> allocator = new PriorityQueue<>((a,b) -> a - b);

        // sort the arrays based on ascending order for start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // add end time to the priority queue by using min heap approach
        allocator.add(intervals[0][1]);

        // iterating through the itervals and comparing start time with end time added in the heap
        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] >= allocator.peek()) {

                // remove from the heap
                allocator.poll();
            }

            // add the interval if start time is more then end time
            allocator.add(intervals[i][1]);


        }


        return allocator.size(); // size indicates no of meeting rooms required

    }
}