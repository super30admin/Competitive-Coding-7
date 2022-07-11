// Time Complexity : O(mxn)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//253. Meeting Rooms II
//https://leetcode.com/problems/meeting-rooms-ii/


class Solution {
    public int minMeetingRooms(int[][] intervals) {
         
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[1]==b[1])
                return a[0]-b[0];
            
            return a[1]-b[1];});
        int m = intervals.length;
        int n = intervals[0].length;
        
        
        for(int i=0; i<m; i++){
                    pq.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        
        List<Integer> list = new ArrayList<>();
        int count = 1;
        
        int temp = 0;
        int t = 0;
        int[] res = pq.poll();
        list.add(res[1]); int N = 0;
        boolean flag = false;
        int f =0; 
        int min = 1000000;
        int temporary = 0;
        int toRemove = 0;
        
        while(!pq.isEmpty()){
           
            res = pq.poll();
            N = list.size();
            int k = 0;
            while(k<N){
                
                
                if(list.get(k) > res[0]){
                    if(f != 1){
                        flag = true;  temp = list.get(k); t = k;
                    }
                     
                    
                }else{ 
                    if(min>Math.abs(list.get(k)-res[1])){
                        min = Math.abs(list.get(k)-res[1]);
                        toRemove = list.get(k);
                        temporary = res[1];
                        f = 1;
                    }
                }
                
                k++;
            }
            
            if(flag == true && temp == list.get(t)){
                list.add(res[1]); 
                count++;
            }
            if(f == 1){
                list.remove(list.indexOf(toRemove)); 
                list.add(temporary);
                min = 1000000;
            }
            f = 0;
            flag = false;
            
             
        }
        
        for(int h=0; h<list.size(); h++){
            System.out.println(list.get(h));
        }
        
        return count;
    }
}
