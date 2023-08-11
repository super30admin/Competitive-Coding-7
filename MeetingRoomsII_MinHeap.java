import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomsII_MinHeap {

        //MIN HEAP  -  O(NlogN)

        public int minMeetingRooms(int[][] intervals) {

            // sorting intervals by ascending start times
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // O(NlogN)

            //Min Heap to keep track of minimum close times, so that
            // next interval can be in the same (peek) conference room thereby reducing the number of rooms required
            PriorityQueue<Integer> minClose = new PriorityQueue<>();
            //default - min heap

            for(int[] interval: intervals) {

                // if minimum close time among already allocated rooms is before the current interval start time,
                // put this current interval in that peek (min-close time) conference room
                if(!minClose.isEmpty() && minClose.peek() <= interval[0]) {

                    minClose.poll();  // O(NlogN)
                }

                minClose.add(interval[1]); // O(N) - space
            }

            return minClose.size();
        }

        public static void main(String[] args) {

            MeetingRoomsII_MinHeap obj = new MeetingRoomsII_MinHeap();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of intervals: ");
            int rows = scanner.nextInt();

            int[][] intervals = new int[rows][2];

            for (int i = 0; i < rows; i++) {
                System.out.println("Enter " + (i+1) + " interval: ");
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                }
            }

            int answer = obj.minMeetingRooms(intervals);

            System.out.println("Minimum number of conference rooms required is " + answer);

        }

}

/*
TIME COMPLEXITY = O(NlogN)

Sorting -  O(NlogN)

N add / remove-min operations - O(NlogN)

SPACE COMPLEXITY = O(N)

all intervals go into min heap in worst case if all intervals have to be kept in different conference rooms
*/