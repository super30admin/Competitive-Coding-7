Topic: Heaps & BinarySearch

Problem#1 Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/

// Time Complexity : O(nlog) + O(klogn) where n is rows
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach
1. Insert first element of each row in the PQ.
2. traverse through first row of the matrix to bring the minimum element of the row on the top of PQ.
3. Return value of top element of PQ.   


//Code:
class Solution {
    class Node{
        int value;
        int row;
        int col;
        Node(int value, int row, int col){
            this.row=row;
            this.col=col;
            this.value=value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0) return -1;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.value-b.value);
        for(int i=0;i<matrix.length;i++){
            pq.add(new Node(matrix[i][0], i, 0));
        }
         Node currentnode=null;
        while(k>0){
            currentnode=pq.remove();
            int newrow=currentnode.row;
            int newcol=currentnode.col+1;
            if(newrow<matrix.length && newcol<matrix[0].length){
                pq.add(new Node(matrix[newrow][newcol], newrow, newcol));
            }
            k--;
        }
        return  currentnode.value;
    }
}



Problem#2 Link: https://leetcode.com/problems/meeting-rooms-ii/submissions/


// Time Complexity : O(nlogn) + O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach
1. Sort the 2D Arrays
2. Insert first subarray into the PQ
3. traverse through the array: If(start time of next meeting is greater than the end of time of top meeting in the queue): remove meeting and add new meeting
else: add new meeting because new room will be needed for the meeting.
4. Return PQ size

//Code:

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if (intervals[0].length==0 || intervals==null) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= pq.peek()){
                pq.remove();
                pq.add(intervals[i][1]);
            }
            else{
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}