
# Meeting Rooms Leetcode

# Code:

# Approach: Put the end time of the first meeting into the heap. Then iterate over the 2nd until the last meeting and make sure to check the start times of the meetings with the top element in the heap.


import heapq
def problem(self, arr): -> int
	#base case:
	If not arr:
	    return 0
	
	arr.sort(key = lambda x: x[0])

	#heap 
	res = [arr[0][1]]
	
	For meeting in arr[1:]:
		If meeting[0]>=res[0]:
			heapq.heapop(res)
		heapq.heappush(res, meeting[1])
	
	return len(res)

# TC: O(nlogn)
# SC: O(n)
