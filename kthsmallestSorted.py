"""
Search the value space using binary search from min to max element
For each mid value, count how many elements in matrix are ≤ mid
If count < k, move right; else move left
"""
"""
Time Complexity: O(n × log(max - min)) - Binary search + count pass
Space Complexity: O(1)
"""


class kthsmallestSorted:
    
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        n = len(matrix)
        low, high = matrix[0][0], matrix[-1][-1]

        def countLessEqual(mid):
            count = 0
            row, col = n - 1, 0
            while row >= 0 and col < n:
                if matrix[row][col] <= mid:
                    count += row + 1
                    col += 1
                else:
                    row -= 1
            return count

        while low < high:
            mid = (low + high) // 2
            if countLessEqual(mid) < k:
                low = mid + 1
            else:
                high = mid
        return low


if __name__ == "__main__":
    obj = kthsmallestSorted()

    matrix = [[1, 5, 9], [10, 11, 13], [12, 13, 15]]
    k = 8
    print(obj.kthSmallest(matrix, k)) 
