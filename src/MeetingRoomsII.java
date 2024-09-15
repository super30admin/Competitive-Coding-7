import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

	public int minMeetingRooms(int[][] intervals) {

		return meetingRoom(intervals);

	}

	private static int meetingRoom(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;

		// if( matrix.length ==1)
		// return 1;

		Arrays.sort(matrix, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(matrix[0][1]);

		for (int i = 1; i < matrix.length; i++) {

			if (matrix[i][0] >= pq.peek()) {

				pq.remove();
				pq.add(matrix[i][1]);

			} else {

				pq.add(matrix[i][1]);
			}

		}

		return pq.size();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
