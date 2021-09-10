class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
            maxHeap = []
            for x in matrix:
                for y in x:
                    if len(maxHeap)<k:
                        heapq.heappush(maxHeap, -y)
                    else:
                        heapq.heappushpop(maxHeap, -y)
            return -maxHeap[0]

sol = Solution()
matrix = [[1,5,9],[10,11,13],[12,13,15]]
k=8
output = sol.kthSmallest(matrix,k)
print('Res: ',output)