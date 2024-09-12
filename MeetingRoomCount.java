Executed in leetcode- No

class Solution {
    public class Meeting{
       public int st;
       public int end;
       public Meeting(int st, int end){
           this.st=st;
           this.end=end;
       } 
    }
 
   
    public int MeetingRooms(int[][] matrix, int k) {
        PriorityQueue<Integer> meetingRoom= new PriorityQueue<Integer>();
        List<Meeting> meetings= new ArrayList<Meeting>();
        for(int i=0;i<matrix.length;i++){
          meetings.add(new Meeting(matrix[i][0],matrix[i][1]));  
        }
        meetings.sort((Meeting a, Meeting b)-> a.st-b.st);
        meetingRoom.add(meetings.get(0).end);
        for(int i=0;i<meetings.size();i++){
            if(meetingRoom.peek()<=meetings.get(i).st){
                meetingRoom.poll();
                meetingRoom.add(meetings.get(i).end);
            }else{
                meetingRoom.add(meetings.get(i).end);
            }
        }
        return meetingRoom.size();
    }
