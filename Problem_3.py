"""
Time Complexity : O(nlogk) where k is the number of points we want to return 
Space Complexity : O(k) - size of the heap
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, we need to calculate the euclidian distance and use max heap for sorting. We would maintain a heap of
size k, and as soon as the size reaches k, the maximum distance at the top would be popped out. In order
to use the max heap, i have modified the min heap by inputting negative values of the distance. So, the maximum
distance would have minimum value and it would be popped out first.
"""
from heapq import heappush as insert
from heapq import heappop as remove


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        heap = []
        result = []
        for p in points:
            dist = -(p[0]**2+p[1]**2)
            insert(heap, [dist, p])
            if len(heap) > K:
                remove(heap)
        for i in heap:
            result.append(i[1])
        return result
