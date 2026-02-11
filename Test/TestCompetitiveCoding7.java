public class TestCompetitiveCoding7 {
    public static void main(String[] args) {
        //test Kth smallest element in a matrix
        KthSmallestTermInAMatrix matrix = new KthSmallestTermInAMatrix();
        int[][] values = {
                {1, 5, 9},
                {10, 11, 13},
                {12,13,15}
        };
        System.out.println("Kth smallest element in a given matrix is " +matrix.kthSmallest(values, 8));
        // Test Number of meeting rooms required to full fill in the given intervals
        MeetingRooms2 meetingRooms = new MeetingRooms2();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println("No of meeting rooms required are " + meetingRooms.minMeetingRooms(intervals));
        System.out.println("No of meeting rooms required for second intervals are " + meetingRooms.minMeetingRooms(intervals2));


    }
}
