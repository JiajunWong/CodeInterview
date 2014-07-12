package InterviewCode;

import java.util.Arrays;

public class LongestValidParentheses
{
    public int longestValidParentheses(String s)
    {
        int result = 0;
        int length = s.length();
        int d[] = new int[length];

        Arrays.fill(d, 0);

        for (int i = length - 2; i >= 0; i--)
        {
            if (s.charAt(i) == '(')
            {
                int j = i + 1 + d[i + 1];
                if (j <= length - 1 && s.charAt(j) == ')')
                {
                    d[i] = d[i + 1] + 2;
                    if (j + 1 <= length - 1)
                    {
                        d[i] += d[j + 1];
                    }
                }
                result = Math.max(result, d[i]);
            }
        }

        return result;
    }
}
