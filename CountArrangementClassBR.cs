// BruteForce Solution
// TC O(2^n)
// SC O(n)

public class Solution
{
    int result;
    HashSet<String> hashset;
    public int CountArrangement(int n)
    {
        if (n == 1)
        {
            return 1;
        }

        int[] array = new int[n];
        result = 0;
        hashset = new HashSet<string>();
        for (int i = 0; i < n; i++)
        {
            array[i] = i + 1;
        }
        Recurse(array, 0, 1, n);
        return result;
    }

    public void Recurse(int[] array, int i, int j, int n)
    {
        //base
        var key = string.Join("", array);
        if (i == n || j == n || hashset.Contains(key))
        {
            return;
        }

        //logic
        hashset.Add(key);
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        bool isAllZero = false;
        for (int k = 0; k < n; k++)
        {
            if (array[k] % (k + 1) == 0 || (k + 1) % array[k] == 0)
            {
                isAllZero = true;
                continue;
            }
            isAllZero = false;
        }
        if (isAllZero)
        {
            result++;
        }

        Recurse(array, i, j + 1, n);
        Recurse(array, i + 1, j, n);

    }
}