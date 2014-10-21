package interviewQuestion;

/*
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") -> false
isMatch("aa","aa") -> true
isMatch("aaa","aa") -> false
isMatch("aa", "*") -> true
isMatch("aa", "a*") -> true
isMatch("ab", "?*") -> true
isMatch("aab", "c*a*b") -> false 
*/

//http://offercoming.blogspot.com/2013/11/wildcard-matching.html
//http://blog.sina.com.cn/s/blog_b9285de20101gw2x.html
//http://my.oschina.net/jdflyfly/blog/284264
public class WildcardMatching
{
    public boolean isMatch(String s, String p)
    {
        int n = s.length();
        int m = p.length();

        int i = 0;
        int j = 0;
        int star = -1;
        int sp = 0;

        while (i < n)
        {
            //one * and multiple *, same effect
            while (j < m && p.charAt(j) == '*')
            {
                star = j++; //* match 0 character
                sp = i;
            }

            if (j == m || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?'))
            {
                if (star < 0)
                    return false;
                else
                {
                    j = star + 1;
                    i = ++sp; //* match 1 character
                }
            }
            else
            {
                i++;
                j++;
            }
        }

        while (j < m && p.charAt(j) == '*')
            j++;
        return j == m;
    }

    public boolean isMatchII(String s, String p)
    {
        if (s == null)
            return p == null;
        if (p == null)
            return s == null;

        int m = p.length();
        int n = s.length();

        int count = 0;
        for (int i = 0; i < m; i++)
        {
            if (p.charAt(i) != '*')
                count++;
        }
        if (count > n)
            return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= m; i++)
        {
            if (p.charAt(i - 1) == '*')
            {
                int j = n + 1;
                for (int k = 0; k <= n; k++)
                {
                    if (dp[k])
                    {
                        j = k;
                        break;
                    }
                }
                for (; j <= n; j++)
                    dp[j] = true;
            }
            else
            {
                for (int j = n; j >= 1; j--)
                {
                    dp[j] = (dp[j - 1] && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?'));
                }
            }
            dp[0] = dp[0] && (p.charAt(i - 1) == '*');
        }

        return dp[n];
    }
}
