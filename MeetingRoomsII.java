class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList <int[]> list = new LinkedList<>();

        list.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {

            if (list.getLast()[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }

        }

        return list.size();
    }
}