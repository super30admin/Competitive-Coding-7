var meetingRoom = function(intervals){
    if(intervals.length == null || intervals.length == 0) return 0;
    intervals.sort(a,b => a[0]-b[0]);
    let pq = [];
    pq.push(intervals[0][1]);
    let rooms = 1;
    for(let i = 1; i< intervals.length; i++){
        
            if(intervals[i][0] < pq[0]) {
                rooms = rooms +1;
                pq.push(intervals[i][1]);
                pq.sort(a,b => a-b);
            } else {
                pq.shift();
                pq.push(intervals[i][1]);
                pq.sort(a,b => a-b);

            }
        
    }
    return rooms;
}