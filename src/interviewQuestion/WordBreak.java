package interviewQuestion;

import java.util.Set;

/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"]. 
*/
public class WordBreak
{
    public boolean wordBreakII(String s, Set<String> dict)
    {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++)
        {
            if (dict.contains(s.substring(0, i)))
            {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && dict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
