//378. Kth Smallest Element in a Sorted Matrix.java
//TimeComplexityO(k)
//SpaceComplexityO(k)


class Solution {
    class node{
        int val;
        int x;
        int y;
        node(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    
    public int kthSmallest(int[][] matrix, int k) {
    HashSet<List<Integer>> used = new HashSet<>();    
     int i = 0;
     int j = 0;
    int count = 0;    
    PriorityQueue<node> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
    pq.add(new node(matrix[0][0],0,0));
    node current = null; 
        while(count < k){
           current = pq.poll();
            
            //process the current node
            //by adding two more nodes and increasing the counter
            //check if right node is in range
           
            if(current.y + 1 < matrix[0].length){
                
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(current.x);
                temp.add(current.y+1);
                
                if(!used.contains(temp)){
                    pq.add(new node(matrix[current.x][current.y+1], current.x, current.y+1));
                    used.add(temp);    
                }
            }
            //same for the node below current node
            if(current.x + 1 < matrix.length){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(current.x+1);
                temp.add(current.y);
                
                if(!used.contains(temp)){
            
                    pq.add(new node(matrix[current.x+1][current.y], current.x+1, current.y));
                    used.add(temp);    
                }
      
          }
            
            count++;
        }
    if(current == null)
            return 0;
    return current.val;
    }
    
}
