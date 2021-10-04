import java.util.*;

public class CompetitiveCoding{
    // time complexity: n
    // space complexity : n
    // did it run on leetcode : yes
    // any doubt : no
    //https://www.lintcode.com/problem/919/
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        //null check
        if(intervals.size() ==0) return 0;
        Interval[] intervalarr= new Interval[intervals.size()];
        //Arrays.asList(intervals);
        intervalarr = intervals.toArray(intervalarr);
        
        Arrays.sort(intervalarr,((a,b)-> a.start - b.start)); // sorting
        PriorityQueue<Interval> minheap = new PriorityQueue<>((a,b)-> a.end-b.end);
        minheap.add(intervalarr[0]);
        for(int i =1;i<intervalarr.length;i++){
            Interval curr = intervalarr[i];
            Interval prev = minheap.remove();
            if(prev.end <= curr.start){
                prev.end = curr.end;
            }else{
                minheap.add(curr);
            }
            minheap.add(prev);
        }

        return minheap.size();
    }

     // time complexity: mlogn
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        while(low <= high){
            int mid = low + (high-low)/2;
            int count = helper(matrix,mid);
            
            if ( count < k){
                low = mid + 1;
                
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    
    private int helper(int[][] matrix, int val){
        int row = matrix.length;
        int column = matrix[0].length;
        int count =0;
        for(int i =0;i<row;i++){
            for(int j =column-1;j>=0;j--){
                if(matrix[i][j]<=val){
                    count = count + j+1;
                    break;
                }
            }
        }
        return count;
    }
}