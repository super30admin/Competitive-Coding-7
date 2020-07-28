//Time Complexity: O(nlogn)
//Space Complexity: O(n) worst case
class MeetingRoom {
// Returns minimum number of rooms required
    static int findMeetingRooms(int arr[], int dep[], int n) {
        // Sort start and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // room_needed indicates number of rooms
        // needed at a time
        int room_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is start time,
            // increment count of rooms needed
            if (arr[i] <= dep[j]) {
            room_needed++;
            i++;
            // Update result if needed
            if (room_needed > result)
                result = room_needed;
            }
            // Else decrement count of rooms needed
            else {
                room_needed--;
                j++;
            }
        }
        return result;
    }

    // Driver program to test methods of graph class
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Rooms Required = "
        + findMeetingRooms(arr, dep, n));
    }
}