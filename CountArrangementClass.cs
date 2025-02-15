// TC -> O(n!)
// SC -> O(n )
public class Solution
{
    HashSet<int> visited;
    int count;
    public int CountArrangement(int n)
    {
        visited = new HashSet<int>();
        count = 0;
        Recursion(1, n);
        return count;
    }

    public void Recursion(int i, int n)
    {
        //Base
        if (i > n)
        {
            count++;
            return;
        }

        for (int j = 1; j <= n; j++)
        {
            if (!visited.Contains(j) && (i % j == 0 || j % i == 0))
            {
                visited.Add(j);
                Recursion(i + 1, n);
                visited.Remove(j);
            }
        }
    }
}