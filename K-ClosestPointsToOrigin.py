import heapq
# APPROACH 1, MIN HEAP
# Time Complexity : O(n*log(n)), where n is the total number of coordinates given
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

# This approach uses a Min Heap to sort all elements based on their
# Euclidean Dist, The heap is then popped K times to obtain the result
class Pair(object):
    def __init__(self, input):
        self.list = input
        self.dist = (input[0] ** 2 + input[1] ** 2)

    def __lt__(self, t2):
        return self.dist < t2.dist


class Solution(object):
    def kClosest(self, points, K):
        if not points:
            return []
        # Pushing all input in heap
        pq = []
        for i in points:
            heapq.heappush(pq, Pair(i))
        # Popping k times, getting min based on Euclidean Distance
        retVal = []
        while K != 0:
            retVal.append(heapq.heappop(pq).list)
            K -= 1

        return retVal

#--------------------------------------------------------x-------------------------------------------------------------#

# APPROACH 2, MAX HEAP
# Time Complexity : O(n*log(k)), where n is the total number of coordinates given
# Space Complexity : O(k), where k is given as the input.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

# This approach uses a Max Heap, where only K elements are allowed
# in the heap, The heap is then popped completely to obtain the result!
class Pair(object):
    def __init__(self, input):
        self.list = input
        self.dist = (input[0] ** 2 + input[1] ** 2)

    def __lt__(self, t2):
        return self.dist > t2.dist

    def kClosest(self, points, K):
        if not points:
            return []
        # Pushing input, popping when size > k
        # The max, based on euclidean dist, is popped
        pq = []
        for i in points:
            heapq.heappush(pq, Pair(i))
            if len(pq) > K:
                heapq.heappop(pq)
        # Popping all, only k elems in heap
        retVal = []
        while pq:
            retVal.append(heapq.heappop(pq).list)

        return retVal
