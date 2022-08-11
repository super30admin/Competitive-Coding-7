//Time Complexity: O(n^2) + O(n*log(n))
//Space Complexity: O(n); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem1_1 {
    
    int result;
    boolean[] visited;
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        visited = new boolean[n];
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        for(int i =0; i <n; i++){
            
            if(visited[i] != true){
                    dfs(intervals, i, 0);    
            }
                
        }
        
        return result;
    }
    
    private void dfs(int[][] intervals, int index, int endTime){
        
        if(index == intervals.length){
            
             result++;
             return;
        }
           
        
        if(visited[index] == true || intervals[index][0] < endTime)
        {
            dfs(intervals, index +1, endTime);
        }
        
        else if(intervals[index][0] >= endTime)
        {
            dfs(intervals, index +1, intervals[index][1]);
            visited[index] = true;
        }
        
    }
}
