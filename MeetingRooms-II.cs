
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//TC: O(nlogn)
//SC O(1)
private static int MeetingRooms(List<List<int>> meetings)
{
    if(meetings == null || meetings.Count() == 0)
        return 0;
    int n = meetings.Count;
    int[] start = new int[n];
    int[] end = new int[n];
    
    for(int i = 0; i < n; i++)
    {
        start[i] = meetings[i][0];
        end[i] = meetings[i][1];
    }
    
    Array.Sort(start);
    Array.Sort(end);
    
    int startIndex = 0;
    int endIndex = 0;
    int rooms = 0;
    
    while(startIndex < meetings.Count())
    {
        // If there is a meeting that has ended by the time the meeting at `start_index` starts
        if (start[startIndex] >= end[endIndex]) {
            rooms -= 1;
            endIndex += 1;
        }
        
        startIndex++;
        rooms += 1; 

    }
    return rooms;
}


//TC O(nlogn)
///SC O(n)
private static int MeetingRooms(List<List<int>> meetings)
{
    if(meetings == null || meetings.Count() == 0)
        return 0;
    //Sort all elements in meeting by start time
    meeting.Sort()

    PriorityQueue<int, int> pq = new PriorityQueue<int, int>();
    int rooms = 0;
    for(int i = 0; i < meetings.Count; i++)
    {
        if(i == 0 || pq.Count == 0)
        {
            rooms++;                
        }
        else
        {
            if(meetings[i-1][1] > meetings[i][0] && pq.Peek() > meetings[i][0])
                rooms++;
            else
            {
                pq.Dequeue();                    
            }
        }
        pq.Enqueue(meetings[i][1], meetings[i][1]);
    }
    return rooms;
}