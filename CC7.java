# Competitive-Coding-7

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    int count; int low; int high;
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int m = matrix.length;
        int high = matrix[m-1][m-1];
        while(low < high) {
            int mid = low + (high -low)/2;
            int bindex = findindex(matrix, m, mid);
            if(count < k) {
                low = mid+1;
            }
            else high = mid;
        }
        return low;
    }
    private int findindex(int[][] matrix, int m, int target) {
        int i = m-1;
        int j = 0;
        count = 0;
        while(i >=0 && j < m) {
            if(matrix[i][j] <= target){
                j++;
                count =count + i + 1;
            }
            else {
                i--;
            }
        }
        return count;
    }
}


public class Solution2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue pq = new PriorityQueue<>();
        for(int[] interval: intervals) {
            if((!pq.isEmpty()) && (pq.peek() <= intervals[0]))
                pq.poll();
            pq.add(intervals[1]);
        }
        return pq.size();
    }
}