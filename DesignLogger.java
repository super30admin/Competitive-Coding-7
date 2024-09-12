import java.util.HashMap;
/*
Time Complexity: O(1), as the HashMap containsKey method take constant time
Space Complexity: O(n), n is space complexity as we are taking HashMap
Run on leetcode: yes

Approach:
1. To design it I thought to use HashMap as it would enable me to store message as the key and timestamp as the value
2. Now for the first time I will check if th given string is present in my HashMap or not, is that is present I would check
the diff between prevTime and given timeStamp and based on that I will return whether I wanna print that or not
3. If that string is not present in the map then I am gonna add that and return true for the first time
 */
public class DesignLogger {
    public HashMap<String, Integer> map;
    public DesignLogger(){
        map = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message){

        if(map.containsKey(message)){
            int prevTime = map.get(message);
            if(timestamp-prevTime >=10){
                return true;
            }else{
                return false;
            }
        }else{
            map.put(message, timestamp);
            return true;
        }
    }
    public static void main(String[] args){
        DesignLogger logger = new DesignLogger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage( 3, "foo"));
        System.out.println(logger.shouldPrintMessage( 8, "bar"));
        System.out.println(logger.shouldPrintMessage( 10, "foo"));
        System.out.println(logger.shouldPrintMessage( 11, "foo"));
    }
}
