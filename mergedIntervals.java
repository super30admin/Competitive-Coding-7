//Time: O(n log n)
//Space: O(log n) avg, worse case: O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (s,e) -> s[0] - e[0]);
        
        List<int[]> result = new ArrayList<int []>();
        
        //we can keep the subarray pair
        int[] old_pair = intervals[0];
        
        
        /*
            conditions for overlap: if old end > start of next event
            update the end if the new end > old end
        */
        for(int i = 1; i < intervals.length; i++) {
            
            if(old_pair[1] > intervals[i][1])
                continue;

            if(old_pair[1] >= intervals[i][0]) {  //overlap, merge into old pair with new values
                old_pair[1] = intervals[i][1];
                
            }
            else {
                result.add(old_pair); 
                old_pair = intervals[i];
             }
             
        }
        
        result.add(old_pair); 
        //return in the right format
        return result.toArray(new int[result.size()][]);
           
    }
}