class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp >= map.getOrDefault(message,Integer.MIN_VALUE)+10){
            map.put(message, timestamp);
            return true;
        }
        else
            return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */