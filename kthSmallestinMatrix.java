//time complexity O(klog(row.length))
//space complexity O(row.length)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Que> pq=new PriorityQueue<>((a,b)-> a.val-b.val );
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            Que q=new Que(matrix[i][0],i,0);
            pq.add(q);
        }
        while(k>0){
            Que q1=pq.poll();
            int i=q1.i;
            int j=q1.j;
            if(k==1){
                return q1.val;
            }
            if( j<col-1 ){
            Que q2=new Que(matrix[q1.i][q1.j +1],q1.i,q1.j+1);
            pq.add(q2);
            
            } 
            k--;
            
        }
        
        return 0;
    }
    
}
class Que{
    int val;
    int i;
    int j;
    public Que(int val,int i,int j){
        this.val=val;
        this.i=i;
        this.j=j;
    }
}