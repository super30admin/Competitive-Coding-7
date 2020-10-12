// Time Complexity : O(nlogn)  (for sort+traverse through array)
// Space Complexity : O(n), when all meetings require different rooms and be in the queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//sort the array with starting times of meeting
//lets take a priority queue with heap property and push the first end time to it
//we shall traverse through the array, and compare the next meeting start time to prev meeting end time in queue
//if it is greater , then extra room is not needed, remove the min end time and add the current meeting end time 
//else we need an extra room and add to the queue.
//return the size of queue



import java.util.Arrays;
import java.util.PriorityQueue;

class Rooms {
    public static int totalRooms(int[][] arr){
        if(arr==null|| arr.length==0){
            return 0;
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> res=new PriorityQueue<>();
        res.add(arr[0][1]);

        for(int i=1;i<arr.length;i++){
            int curr=arr[i][0];
            if(curr<res.peek()){
                res.add(arr[i][1]);
            }
        else{ res.remove();
            res.add(arr[i][1]);

        }

        }
        return res.size();

    }

    public static void main(String[] args){
        int[][] arr={{0,30},{5,10},{15,20},{0,30}};
        System.out.println(totalRooms(arr));

    }
}