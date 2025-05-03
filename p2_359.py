# 359. Logger Rate Limiter
# TC : O(1) for each call to shouldPrintMessage
# Dictionary lookups and updates are constant time operations

# SC : Space Complexity: O(M) where M is the number of unique messages
# We store at most one entry per unique message in the last_printed dictionary

# Did this code successfully run on Leetcode : Yes

# Approach :
# We use a dictionary (hash map) to track when each unique message was last printed
# For each incoming message, we check if either:
    # We've never seen this message before (not in our dictionary)
    # It's been at least 10 seconds since we last printed this message
# If either condition is true, we update the last printed timestamp and return True
# Otherwise, we return False to indicate the message should not be printed

class Logger:
    def __init__(self):
        # Dictionary to store the last timestamp a message was printed
        # Key: message content, Value: timestamp when it was last printed
        self.last_printed = {}
        
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        # Check if this is the first time seeing this message or
        # if it's been at least 10 seconds since we last printed it
        if message not in self.last_printed or timestamp >= self.last_printed[message] + 10:
            # Update the last printed timestamp for this message
            self.last_printed[message] = timestamp
            return True
        # Otherwise, we've seen this message recently (within 10 seconds)
        return False