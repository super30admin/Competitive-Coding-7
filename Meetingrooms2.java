/*
import heapq
class Solution:
    def meetingRooms(self,arr):
        if len(arr) == 0:
            return 0
        arr.sort(key = lambda x: x[0])    
        heap = []
        heapq.heappush(heap, arr[0][1])
        
        for i in range(1,len(arr)):
            if arr[i][0] >= heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, arr[i][1])
            else:
                heapq.heappush(heap, arr[i][1])
        return len(heap)

s = Solution()

arr = [[30,35],[1,5], [5,10], [2,30]]
arr = [[7,10], [2,4]]
arr = [[0,30], [5,32], [15,20], [6,15]]
print(s.meetingRooms(arr))

*/
// Time - O(nlogn) for sorting + O(nlogn) for heap in worst case where we will require room for every input
// Space - O(n) in worst case all would be present in heap
// Logic - Just added elements to heap and checked every time the next coming input with first element of heap
import java.util.*;
class Meetingrooms2{
    public static int meetingRooms(int[][] arr){
        if (arr == null || arr.length == 0)
        return 0;

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for (int i=1; i<arr.length; i++){
            if (arr[i][0] >= pq.peek()){
                pq.remove();
                pq.add(arr[i][1]);
            }
            else{
                pq.add(arr[i][1]);
            }
        }
        return pq.size();
    }

    public static void main(String args[]){
        //int[][] arr = {{30,35}, {1,5}, {5,10}, {2,30}};
        int[][] arr = {{0,30}, {5,32}, {15,20}, {6,15}};
        System.out.println(meetingRooms(arr));
    }
}
