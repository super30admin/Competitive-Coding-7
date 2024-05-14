Problem-1: Meeting rooms-ii
//TC = (nlogn)
// SC = n;
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length ==0){
            return 0;
        }
//         priority queue with  a comparator of end times
//         sort intervals with start times
//         then keep asking from priority queue if a. room is available, if not, add new room's end time to q
//         return it's size
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(a, b));
        
        q.offer(intervals[0][1]);
        
        for( int i=1 ; i<intervals.length; i++){
            if(intervals[i][0] >= q.peek()){
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        
        return q.size();
    }
}

Problem-2: kth smallest element in sorted matrix
TC = O(nlogk) 
SC = O(k)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        
        
        PriorityQueue<Integer> q = new PriorityQueue<>( (a, b) -> b - a);
        
        for( int i=0; i < matrix.length; i++){
            for( int j=0; j < matrix[0].length; j++){ 
                
                if(q.size() < k){ // 0, 1, 2, 3, 4, 5, 6, 7, 8
                    q.add(matrix[i][j]); // [1], [5,1], [9,5,1], [10,9,5,1],  [11,10,9,5,1],  [13,11,10,9,5,1],   [13,13,11,10,9,5,1]
                }else{
                    if(matrix[i][j] < q.peek()){ // 15 <  13
                        q.poll();
                        q.add(matrix[i][j]);
                    }
                }
                
            }
        }
        
        
        return q.poll(); // [13,13,11,10,9,5,1] = 13
        
    }
}
