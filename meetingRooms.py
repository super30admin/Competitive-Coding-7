# Time Complexity : O(k logN)
# Space Complexity : O(heap size)
# Did this code successfully run on Leetcode : On the editor yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

from heapq import heappop, heappush
def minMeetingRooms(matrix):
    #edge cases
    if not matrix:
        return 0
    
    #sort the matrix by start times bc it matters to check prev end heap time
    matrix.sort(key=lambda x : x[0])
    
    heap = [] 
    heappush(heap, matrix[0][1])
    
    #need to push end times into my heap
    
    for i in range(1, len(matrix)):
        #check for conflicts/overlap
        if heap[0] >= matrix[0][1]:
            heappop(heap)
        #push into my heap the end time
        heappush(heap, matrix[i][1])
    return len(heap)

matrix = [[0,30], [5,10], [15,20]]

print(minMeetingRooms(matrix))

