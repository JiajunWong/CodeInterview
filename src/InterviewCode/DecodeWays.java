package InterviewCode;

//http://blog.csdn.net/u011095253/article/details/9248109
public class DecodeWays
{
    //DFS
    public int numDecodings(String s)
    {
        if (s.length() == 0)
        {
            return 0;
        }
        int[] result = new int[1];
        dfs(s, result);
        return result[0];
    }

    private void dfs(String s, int[] result)
    {
        if (s.length() == 0)
        {
            result[0]++;
        }
        for (int i = 0; i <= 1 && i < s.length(); i++)
        {
            if (isValid(s.substring(0, i + 1)))
            {
                dfs(s.substring(i + 1), result);
            }
        }
    }

    //DP
    public int numDecodingsDP(String s)
    {
        int len = s.length();
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (isValid(s.substring(0, 1)))
        {
            dp[1] = 1;
        }
        else
        {
            dp[1] = 0;
        }
        for (int i = 2; i <= len; i++)
        {
            if (isValid(s.substring(i - 1, i)))
            {
                dp[i] = dp[i - 1];
            }
            if (isValid(s.substring(i - 2, i)))
            {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    private boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
        {
            return false;
        }
        int code = Integer.parseInt(s);
        return code > 0 && code < 27;
    }
}
