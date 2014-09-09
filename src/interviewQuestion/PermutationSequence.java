package interviewQuestion;

public class PermutationSequence
{
    public String getPermutation(int n, int k)
    {
        boolean[] output = new boolean[n];
        StringBuilder buf = new StringBuilder("");

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * i;

        for (int i = n - 1; i >= 0; i--)
        {
            int s = 1;

            while (k > res[i])
            {
                s++;
                k = k - res[i];
            }

            for (int j = 0; j < n; j++)
            {
                if (j + 1 <= s && output[j])
                {
                    s++;
                }
            }

            output[s - 1] = true;
            buf.append(Integer.toString(s));
        }

        return buf.toString();
    }
}
