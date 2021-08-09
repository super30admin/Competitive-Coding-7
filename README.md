# Competitive-Coding-7

//Time Complexity = O(NlogN + NlogK)
//Space Complexity = O(N)

class Solution {
public int minMeetingRooms(int[][] intervals) {
if(intervals == null || intervals.length == 0) {
return 0;
}
Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
int result = 0;
PriorityQueue<Integer> queue = new PriorityQueue<>();
queue.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            //start position less than queue.peek
            if(intervals[i][0] >= queue.peek()) {
                queue.poll();
                queue.add(intervals[i][1]);
            }  //start position more than queue.peek
             else {
                queue.add(intervals[i][1]);
            }

        }
        return queue.size();
    }

}

//Time Complexity = O(logN)
//Space Complexity = O(1)

class Solution {
public int kthSmallest(int[][] matrix, int k) {
if(matrix == null || matrix.length == 0) {
return 0;
}
int low = matrix[0][0];
int n = matrix.length-1;
int high = matrix[n][n];

        while(low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            int j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count = count + j+1;
            }

            if(count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
