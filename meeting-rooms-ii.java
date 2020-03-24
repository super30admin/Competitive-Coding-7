// Time Complexity : O(N+NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        for (Interval interval : intervals) {
            Interval tmp = pq.poll();
            if (tmp == null || interval.start < tmp.end) {
                pq.offer(interval);
                if (tmp == null) continue;
            }
            else {
                tmp.end = interval.end;
            }
            pq.offer(tmp);
        }
        return pq.size();
    }
}

/*--------------------------------------------------------------*/
// Time Complexity : O(N+NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// "static void main" must be defined in a public class.
public class Main {
    
    public static int meetingRooms(int[][] intervals)
    {
        //base case
        if(intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++)
        {
            int peekVal=minHeap.peek();
            if(intervals[i][0] > peekVal) {
                minHeap.remove();
                minHeap.add(intervals[i][1]);
            } else {
                minHeap.add(intervals[i][1]);
            }
        }
        return minHeap.size();
    }
    public static void main(String[] args) {
        //int[][] intervals={{0,30},{5,10},{15,20}};
        int[][] intervals={{0,30},{5,32},{15,20},{6,9}};
        System.out.println(meetingRooms(intervals));
    }
}
