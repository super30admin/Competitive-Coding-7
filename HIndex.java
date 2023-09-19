//TC = O(logn)
//SC = O(1)
// Here we need to find the position to move the left and rigt pointer.
class HIndex{
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left =  0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(mid == citations[n-mid]) return citations[mid];
            else if(mid<citations[n-mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
return n-left;
    }
}