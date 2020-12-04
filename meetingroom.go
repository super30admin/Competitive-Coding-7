// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
sort all intervals according to start time
create a minheap and add the first interval end time to heap
set count to 1
for each of the rest of the intervals
check if start is less than min heap element end if so increment count by 1 else pop min element
finally push the current element end
return count
*/
package main

import (
	"container/heap"
	"fmt"
	"sort"
)

type IntHeap []int

func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) Swap(a, b int) {
	h[a], h[b] = h[b], h[a]
}

func (h IntHeap) Less(a, b int) bool {
	return h[a] < h[b]
}

func (h *IntHeap) Push(v interface{}) {
	*h = append(*h, v.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0:n-1]
	return x
}

func meetingRooms(intervals [][]int) int {
	if intervals == nil || len(intervals) == 0 {
		return 0
	}
	fmt.Println(intervals)
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0]< intervals[j][0]
	})
	fmt.Println(intervals)

	c := 1
	mh := &IntHeap{}
	heap.Init(mh)
	heap.Push(mh, intervals[0][1])

	for i:=1;i<len(intervals);i++ {
		temp := heap.Pop(mh)
		if intervals[i][0] < temp.(int){
			heap.Push(mh, temp)
			c++
		} else {
			heap.Pop(mh)
		}
		heap.Push(mh, intervals[i][1])
	}
	return c
}

func MainMeetingRoom() {
	// priority queue
	fmt.Println(meetingRooms([][]int{{5, 10}, {0, 30}, {15, 20}}))
}
