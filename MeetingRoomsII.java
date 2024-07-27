import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//time - O(n + log n), space - O(n)
class MeetingRoomsII {
    public int minMeetingRooms(int[][] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nums[0][1]);

        for(int i=1; i<nums.length; i++) {
            if(pq.peek() <= nums[i][0]) {
                pq.poll();
            }
            pq.add(nums[i][1]);
        }

        return pq.size();
    }
}
