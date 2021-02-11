//Time Complexity: O(X+Klog(X)) where x is min(k,n) 
//Space Complexity: O(x) 

class MyHeapNode {

  int row;
  int column;
  int value;

  public MyHeapNode(int v, int r, int c) {
    this.value = v;
    this.row = r;
    this.column = c;
  }

  public int getValue() {
    return this.value;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }
}

class MyHeapComparator implements Comparator<MyHeapNode> {
  public int compare(MyHeapNode x, MyHeapNode y) {
    return x.value - y.value;
  }
}

class Solution {

  public int kthSmallest(int[][] matrix, int k) {

    int N = matrix.length;

    PriorityQueue<MyHeapNode> minHeap =
        new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());

    for (int r = 0; r < Math.min(N, k); r++) {
      minHeap.offer(new MyHeapNode(matrix[r][0], r, 0));
    }

    MyHeapNode element = minHeap.peek();
    while (k-- > 0) {
      element = minHeap.poll();
      int r = element.getRow(), c = element.getColumn();

      if (c < N - 1) {

        minHeap.offer(new MyHeapNode(matrix[r][c + 1], r, c + 1));
      }
    }

    return element.getValue();
  }
}