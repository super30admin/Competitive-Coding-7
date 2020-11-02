# O(N * LOG(N)) TIME AND K SPACE WHERE N IS LEN OF ARRAY

def kthSmallest(array, k):
    heap = []
	for i in range(k):
		heapq.heappush(heap,-array[i])
	for i in range(k,len(array)):
		current = -array[i]
		if current > heap[0]:
			heapq.heappop(heap)
			heapq.heappush(heap,current)
	return -heap[0]