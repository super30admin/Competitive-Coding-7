// Time Complexity:  O(n)
// Space Complexity: O(n)

class Logger {

  Map<String, Integer> map;
  
  public Logger() {
    this.map = new HashMap<>();
  }
  public boolean shouldPrintMessage(int timestamp, String message) {
    if(map.containsKey(message)) {                                             // if message repeated
      if(timestamp - map.get(message) < 10) {                                  // and it is within time frame
        return false;
      }
    }
    map.put(message, timestamp);                                               // if new message OR repeated message then timestamp updated
    return true;
  }
}
