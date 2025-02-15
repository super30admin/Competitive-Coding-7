//TC -> O(1)
//SC -> O(n) where n is total number of logs

public class Logger
{

    Dictionary<string, int> lookup;
    public Logger()
    {
        lookup = new Dictionary<string, int>();
    }

    public bool ShouldPrintMessage(int timestamp, string message)
    {
        if (lookup.ContainsKey(message))
        {
            if (timestamp - lookup[message] >= 10)
            {
                lookup[message] = timestamp;
                return true;
            }
            return false;
        }
        lookup.Add(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * bool param_1 = obj.ShouldPrintMessage(timestamp,message);
 */