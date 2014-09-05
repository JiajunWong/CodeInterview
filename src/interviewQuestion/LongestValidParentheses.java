package interviewQuestion;

import java.util.Arrays;

//http://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
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
                    d[i] = d[i + 1] + 2;//(()())
                    if (j + 1 <= length - 1)
                    {
                        d[i] += d[j + 1];//()()....()
                    }
                }
                result = Math.max(result, d[i]);
            }
        }

        return result;
    }
}
