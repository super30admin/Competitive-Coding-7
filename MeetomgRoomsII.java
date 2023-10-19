//TC -O(nlogn)
//SC- O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        if(intervals.length == 1){
            return 1;
        }

        //sort array based on start time
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        //Intialize a min heap
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<intervals.length; i++){
            if(q.isEmpty()){
                q.add(intervals[i][1]);
            }else{
                if(intervals[i][0] >= q.peek()){
                    q.poll();
                }
                q.add(intervals[i][1]);
            }
        }

        return  q.size();

    }
}