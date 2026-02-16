// For this problem, we use a min‑heap to merge sorted rows, always extracting the smallest available element and pushing the next element from the same row.
//After popping from the heap k times, the last extracted value is the kth smallest element in the matrix.
// time complexity: O(k log m) where m is the number of rows in the matrix, because we perform k extractions from the heap and each extraction takes O(log m) time.
// space complexity: O(m) because the heap can contain at most one element from each of the m rows at any time.

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        
        val m = matrix.size
        val n = matrix[0].size

        val pq = PriorityQueue<IntArray>(compareBy { it[0] })

        for (r in 0 until m) {
            pq.offer(intArrayOf(matrix[r][0], r, 0))
        }

        var kk = k
        var ans = 0

        while (kk > 0) {
            kk--
            val curr = pq.poll()
            ans = curr[0]

            val r = curr[1]
            val c = curr[2]

            if (c + 1 < n) {
                pq.offer(intArrayOf(matrix[r][c + 1], r, c + 1))
            }
        }

        return ans

    }
}