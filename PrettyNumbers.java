//Space Complexity : O(!N)
//Time Commplexity : O(n)

class PrettyNumbers {
    int cnt = 0;
    public int countArrangement(int n) {
        boolean[] arr = new boolean[n+1];
        backtracking(n, 1, arr);
        return cnt;
    }
    public void backtracking(int n, int index, boolean[] arr){
        //base
        if(index > n){
            cnt++;
            return;
        }

        //logic
        for(int i =1; i<=n ;i++){
            if(!arr[i] && (i%index == 0 || index%i ==0)){
                //action
                arr[i] = true;
                //recurse
                backtracking(n , index+1, arr);
                //backtrack
                arr[i] = false;
            }
        }
    }
}