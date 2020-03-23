/*
Linear approch after sorting.
Time complexity:  nlogn for sorting then linear time for calculating total rooms required.
Space complexity: O(n)
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if(len == 0)
            return 0;
        
        //creating start time array and end time array
        int[] start = new int[len];
        int[] end = new int[len];
        
        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        //sorting them 
        Arrays.sort(start);  //nlogn
        Arrays.sort(end); //nlogn
        int st =1, en =0;
        
        int roomsRequired=1, maxRoomRequired=1;
        while(st< len && en < len){
            //prev meeting already finished. we can reuse the room
            if(start[st] >= end[en]){
                roomsRequired--;
                en++;
            }
            //else we need one more room for the current meeting.
            else{
                roomsRequired++;
                maxRoomRequired= Math.max(maxRoomRequired, roomsRequired);
                st++;
            }
        }
        return maxRoomRequired;
    }
}

/*
Using heap
Time complexity: nlogn Heapify process for all n
Space complexity: O(n) where N is total number of meetings.
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //edge case
        if(intervals == null || intervals.length ==0) return 0;
    
        //sort intervals array based on start time of meeting
        Arrays.sort(intervals, comp);
        //custom comparator for sorting.
        Comparator comp = new Comparator<int[]>(){
            public int compare(int[] a , int[]b){
                return a[0]-b[0];
            }
        };
        /*
        So the intution here is that for the current meeting if I want to reuse the meeting room which 
        is previouly allocated but free now I want to check if any previous meeting has ended or not.
        so I want to store the end time of the previous meeting in some data structure. 
        and from that data structure I want which meeting is gonna end first so that I can reuse that room.
        so min heap could store the end time of meetings in sorted order and would give me access to the meeting 
        which gonna end sooner.
        */
        //min heap : for storing end time
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        pq.add(intervals[0][1]);
        for(int i=1 ; i< intervals.length ; i++){
            /*
            case 1. for every meeting i would be checking if start time of the meeting is lesser than whatever is
            there at the top of the queue that means previous meeting has not ended yet. so I need another
            meeting room. I would be adding end time of the cur meeting in the queue.
            
            case 2: if start time of the meeting is greater than or equal to the end time of the meeting 
            which is already ended(top of the peek) then i can reuse the current room so I would be removing 
            previoud meeting which is already ended from the queue. and adding current one to queue.
            */
            if(intervals[i][0] >= pq.peek())
                 pq.remove();
            pq.add(intervals[i][1]);
        }
        //at any point of time size of my heap would be the total rooms required.
        return pq.size();
    }
}
