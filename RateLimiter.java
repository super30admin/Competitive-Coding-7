/*
    Time Complexity - O(1) 
    Space Complexity - O(m), where m is the number of distinct messages received so far.
*/
class Logger {
    Map<String,Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
        /** 
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(map.containsKey(message) && timestamp-map.get(message) < 10)
            return false;
        
        map.put(message,timestamp);
        return true;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
