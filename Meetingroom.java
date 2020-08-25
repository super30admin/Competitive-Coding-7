/*
  Time : O(nlog(n)) for sort array and heap sort.
  Space : O(n) n = total number of slots.
  Run on LeetCode: yes
*/
class Solution {
    class StrtTimeComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] slot1,int[] slot2 ){
            return slot1[0] - slot2[0]; //min heap sort by strt time.
        }
    }

    class EndTimeComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer time1,Integer time2 ){
            return time1 - time2; //min heap
        }
    }
    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> ret = new PriorityQueue<>(new EndTimeComparator());
        //O(nlog(n));
        Arrays.sort(intervals, new StrtTimeComparator());

        //O(n) + O(nlogn)
        for(int[] slot: intervals){
            if(ret.size() == 0){
                //got end time val. just compare strt time of a slot
                //to see if intersection.
                ret.offer(slot[1]);
            }
            else{
                if(slot[0] >= ret.peek()){
                    ret.poll();
                }
                ret.offer(slot[1]);
            }
        }
        return ret.size();
    }
}
