/*
# O(nlogn + klogn) -tc    (n is rows)
# O(n) - space 
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if matrix is None or len(matrix) == 0:
            return -1
        
        heap = []
        
        rows, cols = len(matrix), len(matrix[0])
        
        for i in range(rows):
            heapq.heappush(heap, (matrix[i][0], i, 0))
            
        
        while k > 0:
            element, i, j = heapq.heappop(heap)
            new_element_row = i
            new_element_col = j + 1
            if new_element_row < rows and  new_element_col < cols:
                heapq.heappush(heap, (matrix[new_element_row][new_element_col], new_element_row, new_element_col))
                
            k -= 1
        return element
*/

/*
class Node{
    int val;
    int row;
    int col;
    public Node(int value, int r, int c){
        this.val = value;
        this.row = r;
        this.col = c;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return -1;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        int rows = matrix.length, cols = matrix[0].length;
        
        for (int i=0; i<rows; i++)
            pq.add(new Node(matrix[i][0], i, 0));
        
        Node element = null;
        while (k>0){
            element = pq.remove();
            int new_row = element.row;
            int new_col = element.col + 1;
            
            if (new_row < rows && new_col < cols){
                pq.add(new Node(matrix[new_row][new_col], new_row, new_col));
            }
            k--;
        }
        return element.val;
    }
}
*/

/*
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if matrix is None or len(matrix) == 0:
            return -1
        
        rows, cols = len(matrix), len(matrix[0])
        
        low = matrix[0][0]
        high = matrix[rows-1][cols-1]
        while low < high:
            mid = (low + high)//2
            count = self.countNos(matrix, mid, rows, cols)
            
            if count < k:
                low = mid + 1
            else:
                high = mid
                
        return low
        
    def countNos(self, matrix, mid, rows, cols):
        count = 0
        j = cols - 1
        for i in range(rows):
            while j >=0 and matrix[i][j] > mid:
                j -= 1
            count += j + 1
        return count
*/
// Time - O(logn^2) for binary search and O(n^2)/2 for count so total O(n^2/2 logn^2)
// Space - O(1)
// Logic - Used binary search on a range to fit the low such that it is kth smallest
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return -1;
        
        
        int rows = matrix.length, cols = matrix[0].length;
        int low = matrix[0][0], high = matrix[rows-1][cols-1];
        
        while (low < high){                     // had to run this algorithm till low == high and cant exit in between because if noticed then sometimes mid is not present in matrix always
                                                // low or high at some time may not be present in matrix but we can be sure that there will be aleast 1 element present between low and mid and mid and high
                                                // thats why we cant terminate this algo in between like binary search
            int mid = low + (high-low)/2;
            int count = count(matrix, mid, rows, cols);
            
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
        
    }
    private int count(int[][] matrix, int mid, int rows, int cols){ // max - O(n^2)/2
        int c = 0;
        int j = cols - 1;
        for (int i=0; i<rows; i++){
            while (j>=0 && matrix[i][j] > mid)
                j--;
            c += j+1;
        }
        return c;
    }
}