//Time Complexity:O(1)
// Space Complecity: O(M) where M is umber of unique messages encountered. This is because the HashMap stores the latest timestamp for each unique message, and in the worst case, all messages are unique. 
//Code Explained:  We maintain a HashMap to track the latest timestamps for unique messages.
// The shouldPrintMessage method checks if a message has been printed within the last 10 seconds. If not, it updates the HashMap with the current timestamp and returns true, indicating the message should be printed.
// If the message has been printed within the last 10 seconds, the method returns false, indicating the message should not be printed again at this timestamp.

import java.util.HashMap;

public class DesignLoggerRateLimiter {
    private HashMap<String, Integer> messageTimestamps;

    public DesignLoggerRateLimiter() {
        messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message) || timestamp - messageTimestamps.get(message) >= 10) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DesignLoggerRateLimiter logger = new DesignLoggerRateLimiter();

        System.out.println(logger.shouldPrintMessage(1, "Hello")); // Output: true
        System.out.println(logger.shouldPrintMessage(2, "Hello")); // Output: false (already printed within 10 seconds)
        System.out.println(logger.shouldPrintMessage(11, "Hello")); // Output: true (10 seconds have passed since last
                                                                    // print)
        System.out.println(logger.shouldPrintMessage(12, "World")); // Output: true (unique message)
        System.out.println(logger.shouldPrintMessage(19, "World")); // Output: false (already printed within 10 seconds)
    }
}
