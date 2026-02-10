/**
 * @param {number[][]} intervals
 * @return {number}
 Intuition:
1. Separate all start times and end times, then sort them so we can process meetings in time order.
2. When a meeting starts before the earliest ending one finishes, we need a new room; otherwise, we reuse a free room.
3. And I am tracking the maximum number of rooms used at any moment, which is the result. 

T.C: O(n log n)
S.C: O(n)

 */
var minMeetingRooms = function (intervals) {
    const startArr = [];
    const endArr = [];

    for (let [start, end] of intervals) {
        startArr.push(start);
        endArr.push(end);
    };
    // sort start array
    startArr.sort((a, b) => a - b);
    // sort end array
    endArr.sort((a, b) => a - b);

    let i = 0, j = 0;
    let maxRooms = 0;
    let roomsCount = 0;
    while (i < intervals.length) {
        if (startArr[i] < endArr[j]) {
            roomsCount++;
            maxRooms = Math.max(maxRooms, roomsCount);
            i++;
        } else {
            j++;
            roomsCount--;
        }
    }
    return maxRooms;
};