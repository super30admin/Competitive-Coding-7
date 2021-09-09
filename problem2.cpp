//Time Complexity - O(1)
//Space Complexity - O(message)
class Logger {
private:
    unordered_map<string, int> logs;
public:
    /** Initialize your data structure here. */
    Logger() {
        logs.clear();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        if (logs.find(message) == logs.end()) {
            logs[message] = timestamp;
            return true;
        }
        if (logs.find(message) != logs.end() && timestamp - logs[message] >= 10) {
            logs[message] = timestamp;
            return true;
        }
        
        return false;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */