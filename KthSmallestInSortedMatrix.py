class Solution:
	def kSmallest(self, matrix, k):
		self.m = len(matrix)
		self.n = len(matrix[0])

		low = matrix[0][0]
		high = matrix[self.m-1][self.n-1]

		while low < high:
			mid = low + (high-low) // 2
			count = self.findCounts(matrix, mid)

			if count < k:
				low = mid + 1
			else:
				high = mid - 1

		return low

	def findCounts(self, matrix, target):
		i = 0
		j = self.n - 1
		count = 0

		while i < self.m and j >= 0:
			if matrix[i][j] < target:
				count += (j+1)
				i += 1
			else:
				j -= 1

		return count 

s = Solution()
matrix = [[1,5,9],[10,11,13], [12,13,15]]
print(s.kSmallest(matrix, 5))