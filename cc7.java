public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int [] num: intervals){
            if(pq.isEmpty()){
            pq.add(num);
            }else{
                int[] temp = pq.peek();
                if(temp[1]>num[0]){
                    pq.add(num);
                }else{
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.size();

    }
