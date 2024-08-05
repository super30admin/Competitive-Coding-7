// Time Complexity : O(nlogn)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((Pair<Integer, Integer> a, Pair<Integer, Integer> b) ->{
            return a.getKey() - b.getKey();
        });
        Queue<Pair<Integer, Integer>> inner = new PriorityQueue<>((Pair<Integer, Integer> a, Pair<Integer, Integer> b) ->{
            return a.getValue() - b.getValue();
        });
        int counter = 0;
        for(int i=0;i<intervals.length;i++){
            Pair<Integer, Integer> temp = new Pair(intervals[i][0], intervals[i][1]);
            minHeap.add(temp);
        }
        if(inner.isEmpty()){
            counter++;
            inner.add(minHeap.poll());
        }
        while(!minHeap.isEmpty()){
            if(inner.peek().getValue()>minHeap.peek().getKey()){
                counter++;
                inner.add(minHeap.poll());
            }else{
                inner.add(minHeap.poll());
                inner.poll();
            }
        }
        return counter;
    }
}
