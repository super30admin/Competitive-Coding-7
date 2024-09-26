import java.util.*;

public class RoomMeetings {


    public boolean canAttendMeetings_using_Sorting(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetings_bruteForce(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean overlap(int[] interval1, int[] interval2) {
        return (Math.min(interval1[1], interval2[1]) >
                Math.max(interval1[0], interval2[0]));
    }


    public boolean canAttendMeetings(int[][] intervals) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();


        for (int[] interval : intervals) {
            if (map.containsKey(interval[0]))
                return false;
            map.put(interval[0], interval[1]);
            list.add(interval[0]);
            list.add(interval[1]);


        }

        Collections.sort(list);


        for (int i = 0; i < list.size(); i = i + 2) {

            if (!map.get(list.get(i)).equals(list.get(i + 1))) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{465, 497}, {386, 462}, {354, 380}, {134, 189}, {199, 282}, {18, 104}, {499, 562}, {4, 14}, {111, 129}, {292, 345}};
        RoomMeetings roomMeetingsII = new RoomMeetings();
        System.out.println("The ans is " + roomMeetingsII.canAttendMeetings(intervals));
    }
}
