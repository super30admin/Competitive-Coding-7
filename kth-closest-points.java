// Time - O(Nlg K)
// Space - O(K)

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0) {
            return new int[][] {{}};
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((int[] p1, int[] p2) -> {
            return p2[2] - p1[2];
        });
        
        for(int i=0;i<points.length;i++) {
            
            heap.add(new int[] { points[i][0], points[i][1], dist(points[i])}); 
            
            if(heap.size() > K ) {
                heap.remove();
            }
        }
        
        int[][] result = new int[K][2];
        
        for(int i=0;i<K;i++) {
            int[] ele = heap.poll();
            result[i][0] = ele[0];
            result[i][1] = ele[1];
        }
        
        return result;
    }
    
    private int dist(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
