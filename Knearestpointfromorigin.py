#TC : O(nlogK) where n is the number of coordinates and K is the value given
#SC : O(K) to maintain the size of minheap 
import heapq
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        #edge case
        if len(points) < K:
            return []
        
        #for this problem, we will use a min-heap to return the min distance from a pair
        #of coordinates to origin(0,0).
        #we calculate the Euclidean distance = x^2 + y^2 for every ith coordinate in points lists
        #we maintain a min-heap of size K
        #we push the Euclidean distances in -ve value for every ith coordinate
        #min-heap after heapify property will fetch us the min distance and its coordinates
                     
        sqrt_val = []
        
        #traverse through the points list to calculate distance
        for i in points:
            d = i[0]**2 + i[1]**2

            if len(sqrt_val) < K:
                heapq.heappush(sqrt_val,(-d,i))
            else:
                heapq.heappushpop(sqrt_val,(-d,i))
         
          
        
        for i in range(K):
            return [sqrt_val[i][1]]