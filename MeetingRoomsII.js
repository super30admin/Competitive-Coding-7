// Given an array of meeting time intervals where intervals[i] = [starti, endi],
// return the minimum number of conference rooms required.

// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2

// Example 2:
// Input: intervals = [[7,10],[2,4]]
// Output: 1

const minMeetingRooms = (intervals) => {
  // base case
  if (intervals.length == 0 || intervals == null) {
    return 0;
  }
  if (intervals.length == 1) {
    return 1;
  }

  //sort the intervals according to the starting time
  intervals.sort((a, b) => a[0] - b[0]);
  let rooms = [intervals[0]]; // initialize it with the first intervals since we will use it for that

  // this function will return the earliest available room according to the end time of each interval
  const getAvailableRoom = (r) => {
    r.sort((a, b) => a[1] - b[1]);
    return r[0];
  };
  // iterate over each interval and compare the end time of each interval with start time of the earliest available room.
  for (let i = 1; i < intervals.length; i++) {
    let room = getAvailableRoom(rooms);
    let current = intervals[i]; //get the current interval

    // if available room end time is less than start time of current interval,
    // update the room end time, and use it
    if (room[1] <= current[0]) {
      room[1] = current[1];
    }

    // else, add a room
    else {
      rooms.push(current);
    }
  }
  return rooms.length;
};

//test cases
console.log(minMeetingRooms([[0, 30],[5, 10],[15, 20]])); //OP: 2
console.log(minMeetingRooms([[7, 10], [2, 4]])); //OP: 1
console.log(minMeetingRooms([15, 20], [0, 5], [8, 10], [25, 30])); //OP: 1

// T(n) = O(nlogn) => sorting is dominant than iterating over the intervals array
// S(n) = O(n) => in, worst case we will need as many rooms as the number of meetings.
