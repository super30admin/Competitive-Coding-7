#Time complexity - O(n log k)
# Space complexity - O(k)
# Works on leetcode - yes 
# Approach - We make a heap out of the first k elements and then iterate through rest of n-k elements. If any of the n is greater than min element
# in heap, we replace it by n. In the end, we have largest k elements in the heap and return the minimum. 
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = nums[:k]
        heapq.heapify(heap)
        for n in nums[k:]:
            if n> heap[0]:
                heapq.heappushpop(heap,n)
        return heap[0]