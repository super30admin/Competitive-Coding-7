// Time Complexity : O(nLogn) + O(nLogn) + n, hence final tc would be  O(nLogn)
// Space Complexity : O(n): n
// Did this code successfully run on Leetcode : I do not have premium
// Any problem you faced while coding this : Yes. Since JS does not have a priority queue ds,
// I would have to create a min heap class which I am not extremely comfortable with yet.

const minMeetingRooms = (intervals) => {
  let start = intervals.sort((a, b) => a[0] - b[0]);

  let end = [...intervals.sort((a, b) => a[1] - b[1])];

  let rooms = 0;

  let j = 0;

  for (let i = 0; i < intervals.length; i++) {
    if (start[i][0] < end[j][i]) {
      rooms++;
    } else {
      j++;
    }
  }

  return rooms;
};
