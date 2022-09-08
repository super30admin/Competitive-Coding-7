# Time complexity : O(k + n log k) 
# Space complexity : O(k)
# Leetcode : Solved and submitted

import heapq
class Solution:
   # implementing min_heap on the basis of freq value in the Hashmap
    class Distance:
        def __init__(self, val, freq):
            self.val = val
            self.freq = freq
        def __lt__(self, other):
            return self.freq[self.val] < self.freq[other.val]
            
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        self.freq = {}
        res = []
        
        # make a frequency map to keep track of the count of the numbers occuring in the list
        for i in range(n):
            if nums[i] in self.freq:
                self.freq[nums[i]] += 1
            else:
                self.freq[nums[i]] = 1
                
        minHeap = []
        
        # add elements in the heap on the basis of frequency
        for keys in self.freq:
            heapq.heappush(minHeap, self.Distance(keys, self.freq))
            
            # if the length of minHeap goes above k, we remove the element which has the least frequency count, so that atmost we have those k elements
            if len(minHeap) > k:
                heapq.heappop(minHeap)
        
        # at the end, just remove all the elements from the heap and insert into res
        while minHeap:
            key = heapq.heappop(minHeap).val
            res.append(key)
        
        return res
