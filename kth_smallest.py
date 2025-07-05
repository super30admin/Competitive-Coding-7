# Approach (Max-Heap based):
# --------------------------
# 1. Iterate through the matrix.
# 2. Use a max-heap (simulate using negatives in Python's min-heap).
# 3. For each element:
#    - Push the negative value into the heap.
#    - If heap size exceeds k, pop the largest (i.e., the smallest negative value).
# 4. The top of the max-heap will be the kth smallest element (negated back to positive).

# Time Complexity: O(n² * log k)
# - We push every element once: O(n²)
# - Each push/pop takes O(log k)

# Space Complexity: O(k)
# - The heap only holds k elements at any time
import heapq

class Solution:
    def kthSmallest(self, matrix, k):
        maxHeap = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(maxHeap, -matrix[i][j])
            while len(maxHeap) > k:
                    heapq.heappop(maxHeap)
        return -maxHeap[0]


# Main function to test the solution
def main():
    sol = Solution()

    print("Test Case 1:")
    matrix1 = [
        [1, 5, 9],
        [10, 11, 13],
        [12, 13, 15]
    ]
    k1 = 8
    print("Kth Smallest:", sol.kthSmallest(matrix1, k1))  # Expected: 13

    print("\nTest Case 2:")
    matrix2 = [
        [1, 2],
        [1, 3]
    ]
    k2 = 2
    print("Kth Smallest:", sol.kthSmallest(matrix2, k2))  # Expected: 1

    print("\nTest Case 3:")
    matrix3 = [
        [1, 2],
        [3, 4]
    ]
    k3 = 3
    print("Kth Smallest:", sol.kthSmallest(matrix3, k3))  # Expected: 3

if __name__ == "__main__":
    main()