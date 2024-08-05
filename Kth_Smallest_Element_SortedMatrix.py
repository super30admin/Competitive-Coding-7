####378. Kth Smallest Element in a Sorted Matrix##########################################################################################
// Time Complexity : mXn
// Space Complexity : k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
I maintained a minHeap of size mXn-K+1 and iterated through the element and inserted in heap and returned the element at 1st position

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        r,c=len(matrix),len(matrix[0])
        len1=r*c
        maxk=len1-k+1
        print(maxk)
        minheap=[]
        for i in range(r):
            for j in range(c):
                heappush(minheap, matrix[i][j])
                if len(minheap)>maxk:
                    heappop(minheap)   
        #print(minheap)            
        return minheap[0]
        