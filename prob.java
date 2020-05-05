//TC:O(N)
//SC:O(N)

class MyCalendar {
   class Pair
   {
     int x;
     int y;
     public Pair(int x, int y)
     {
         this.x = x;
         this.y=y; 
     }
   }
    
    int k=1;
    HashMap<Integer,Pair> map = new HashMap<>() ;
    public MyCalendar() {
      
       
        
    }
    
    public boolean book(int start, int end) 
    {
      if(map.isEmpty())
      {
         map.put(k,new Pair(start,end)); 
         return true;
      }
      else
      {
        for(int id : map.keySet())
        {
           Pair t = map.get(id);
           if(((t.x <= start) && (start< t.y)) )
               return false;
           if(start<=t.x && t.x < end )
               return false;
        }
          map.put(++k,new Pair(start,end));
          
          return true;   
      }
        
        
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */