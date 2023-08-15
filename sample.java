//Problem 1: Kth smallest element in sorted matrix
// Time Complexity : O(n * log(matrix.max-matrix.min) Best case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Way 1: insert all elements in a Pq and get kth element TC: O(nlogk) SC:O(k)
//Way 2: Insert only Min(n,k) row elements(because kth shortest element wll surely lie in it) in PQ and get kth 
//Way 3: Find range of elements, and return kth smallest->best case with binary search as matrix is sorted
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // int n=mat.length;
        // PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         pq.add(mat[i][j]);
        //         if(pq.size()>k) pq.poll();
        //     }
        // }
        // return pq.peek();

        // PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // int n=matrix.length;
        // int j=Math.min(n,k);
        // for(int i=0;i<j;i++){ //O(j)
        //     q.add(new int[]{matrix[i][0],i,0});
        // }
        // int[] el=q.peek();

        // while(k>0){ //O(klogj)
        //     el=q.poll();
            
        //     if(el[2]<n-1)
        //         q.add(new int[]{matrix[el[1]][el[2]+1], el[1],el[2]+1});

        //     k--;
        // }
        // return el[0];

    int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);
            if (count < k)
                left = mid + 1;
            else
                right = mid-1;
        }
        return left;

    }

    private int getCount(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > mid)
                j--;
            count += j + 1;
        }
        return count;
    }
}


//Problem 2: Meeting rooms 2
// Time Complexity : O(nlog(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// sort according to start times, while u arr a new element to PQ, check if the current top is less than start time, if yes, remove top element and replace with endtime of next interval
// if not then add to pq. means new meeting room is being used
class Solution {
    
    //O(nlogn) //O(n)
    public int minMeetingRooms(int[][] intervals) {
        //null

        Arrays.sort(intervals, (a,b)->a[0]-b[0]); //nlogn
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){ //O(n)  ~ O(nlogn)
            if(!pq.isEmpty() && pq.peek()<=intervals[i][0])
                pq.poll();
            
            pq.add(intervals[i][1]); //logn
        }

        return pq.size();
    }
}
