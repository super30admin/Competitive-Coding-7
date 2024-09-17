// Time Complexity : O(1) Constant since hashmap is being used
// Space Complexity: O(N) where N is the number of entries to hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use hashmap, if the time difference is less than 10 then return false.
*/
public class LogRateLimiter {
    HashMap<String,Integer> hm;
    public Logger() {
        hm=new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean result=false;
        if(!hm.containsKey(message)){
            hm.put(message,timestamp);
            result= true;
        }else{
            if(timestamp-hm.get(message)>=10){
                result=true;
                hm.put(message,timestamp);
            }
        }
        return result;
    }
}
