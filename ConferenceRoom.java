package CompetitiveCoding7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConferenceRoom {
    
   public static void main(String[] args)
   {
       int[][] a = {{0,30},{5,10},{10,20}};
       
       System.out.println(getMinConfRooms(a));
       
   }
    
    
    public static int getMinConfRooms(int[][] times)
    {
        Arrays.sort(times,(a,b)->a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        
        pq.add(times[0]);
        
        for(int i=1;i<times.length;i++)
        {
            
            int[] ele = pq.peek();
            
            if(times[i][0] >= ele[1])
            {
                pq.poll();
            }
            pq.add(times[i]);
        }
        
        return pq.size();
    }

}
