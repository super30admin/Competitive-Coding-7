/*TC - O (NlogN) SC - O (N)*/

/*Approach 1 - using class 
 * */
class Node {
    int start; 
    int end; 
    public Node(int start, int end){
        this.start = start; 
        this.end = end; 
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sort it based on the start times 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.end-b.end); // min heap priority - end times
        
        int rooms = 0 ; 
        for (int i = 0 ; i < intervals.length; i++){
            int[] data = intervals[i]; 
            int s2 = data[0]; 
            int e2 = data[1];
            Node node = new Node(s2, e2);
            
            if (pq.size() == 0){
                pq.add(node);
                rooms += 1;
            } else {
                Node peekNode = pq.peek();
                int s1 = peekNode.start; 
                int e1 = peekNode.end;
                if (e1 <= s2){
                    // does not overlap , remove the peek element and add the new meeting to the heap
                    pq.poll();
                    pq.add(node);
                   
                   
                } else {
                    // overlaps, add to the priority queue 
                    pq.add(node);
                    rooms += 1;
                    
                }
            }      
            
        }
        return rooms;
        
    }
}



/*
 * Apprach using integer array*/



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sort the original array based on the start times.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap priority - end times
        int rooms = 1 ;
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){

                if (pq.peek() <= intervals[i][0]){
                    // does not overlap , remove the peek element and only then add the new meeting to heap
                    pq.poll();

                } else {
                    // overlaps, add to the priority queue

                    rooms += 1;
                }
                  pq.add(intervals[i][1]);
        }
        return rooms;

    }
}
