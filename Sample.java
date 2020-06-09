//Time Complexity:O(NlogN)
//Space Complexity:O(N)
class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0||intervals==null)
            return 0;
       PriorityQueue<Integer> pq= new PriorityQueue<Integer>(
           intervals.length,
           new Comparator<Integer>()
           {
               public int compare(Integer a,Integer b)
           {return a-b;}
           });
        
        Arrays.sort(intervals,new Comparator<int[]>(){public int compare(int a[],int b[]){return a[0]-b[0];}});
        
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=pq.peek())
                pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
-------------------------------------------------------------------------------------
//Time Complexity:O(min(n,k)+klog(min(n,k)))
//Space Complexity:O(min(n,k))
class Cnode
{
    int val;
    int r;
    int c;
    public Cnode(int value,int row,int col)
    {
        this.val=value;
        this.r=row;
        this.c=col;
    }
    
    public int getval()
    {
        return this.val;
    }
    public int getr()
    {
        return this.r;
    }
    public int getc()
    {
        return this.c;
    }
    
}
class CustomComp implements Comparator<Cnode>
{
    public int compare(Cnode x,Cnode y)
    {
        return x.val-y.val;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        if(matrix.length==0||matrix==null)
            return 0;
        PriorityQueue<Cnode> pq= new PriorityQueue(Math.min(n,k),new CustomComp());
        for(int i=0;i<Math.min(n,k);i++)
        {
            pq.offer(new Cnode(matrix[i][0],i,0));
        }
        Cnode ele=pq.peek();
        while(k>0)
        {
          ele=pq.poll();
          int r=ele.r;
          int c=ele.c;
          if(c<n-1)
          {
            pq.offer(new Cnode(matrix[r][c+1],r,c+1));
          }
          k--;
        }
        return ele.val;
    }
}
------------------------------------------------------------------------