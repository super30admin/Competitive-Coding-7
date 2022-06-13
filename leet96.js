TC - O(N^2)
SC - O(N)

/**
 * @param {number[][]} intervals
 * @return {number}
 */
var minMeetingRooms = function(intervals) {
    var start = [],end=[];
    for(let i=0;i<intervals.length;i++)
    {
        start.push(intervals[i][0]);
        end.push(intervals[i][1]);
    }
    start.sort((a,b)=>a-b);
    end.sort((a,b)=>a-b);
    var iter=0,room=0;
    for(let i=0;i<start.length;i++)
    {
        if(start[i]<end[iter])
        {
            room++;
        }
        else{
            iter++;
        }
    }
    return room;
   
};