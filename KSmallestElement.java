class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // return helperBruteForce(matrix, k);
        // return helperMaxHeapPq(matrix, k);
        // return helperMinHeapPq(matrix, k);
        // return helperMinHeapPqWithHashSet(matrix, k);
        return helperBinarSearch(matrix, k);
    }

    // Tc: O(log(N) * 2n)  [n: cols in array mat; m: rows in array mat; N: n*m;]
    // sc: O(1)
    public int helperBinarSearch(int mat[][], int k) {
        int m = mat.length;
        int n = mat[0].length;

        int l = mat[0][0];
        int h = mat[m-1][n-1];

        while(l < h) {
            int mid = l + (h-l)/2;

            int rankOfMid = helperGetRank(mat, mid, m, n);
            if(rankOfMid < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
            return l;
    }

    private int helperGetRank(int mat[][], int target, int m, int n) {
        int i = m - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < n) {
            if (mat[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count;
    }

    // Tc: O(Klog(k))
    // sc: O(2k + 2K)
    public int helperMinHeapPqWithHashSet(int mat[][], int k) {
        int m = mat.length;
        int n = mat[0].length;

        Set<String> visSet = new HashSet<>();
        visSet.add("0,0");
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.offer(new int[] { mat[0][0], 0, 0 });

        while (k-- > 1) {
            int[] top = pq.poll();
            int r = top[1];
            int c = top[2];

            if (c + 1 < n && !visSet.contains(r + "," + (c + 1))) {
                pq.offer(new int[] { mat[r][c + 1], r, c + 1 });
                visSet.add(r + "," + (c + 1));
            }
            if (r + 1 < m && !visSet.contains((r + 1) + "," + c)) {
                pq.offer(new int[] { mat[r + 1][c], r + 1, c });
                visSet.add((r + 1) + "," + c);
            }

        }
        return pq.peek()[0];
    }

    // Tc: O(N + log(N-k)) [n: cols in array mat; m: rows in array mat; N: n*m;]
    // sc: O(k)
    public int helperMinHeapPq(int mat[][], int k) {
        int r = mat.length;
        int c = mat[0].length;
        int n = r * c;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                pq.offer(mat[i][j]);
                if (pq.size() > n - k) {
                    result = Math.max(pq.poll(), result);
                }
            }
        }
        return result;
    }

    // Tc: O(N + logk) [n: cols in array mat; m: rows in array mat; N: n*m;]
    // sc: O(k)
    public int helperMaxHeapPq(int mat[][], int k) {
        int r = mat.length;
        int c = mat[0].length;
        int n = r * c;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (Integer.compare(b, a)));
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                pq.offer(mat[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    // Tc: O(Nlog(N) + N) [n: cols in array mat; m: rows in array mat; N: n*m;]
    // sc: O(N)
    public int helperBruteForce(int mat[][], int k) {
        int r = mat.length;
        int c = mat[0].length;
        int n = r * c;
        int arr[] = new int[n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int pos = (i * r) + j;
                arr[pos] = mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}