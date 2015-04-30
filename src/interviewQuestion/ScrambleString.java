package interviewQuestion;

import java.util.Arrays;

//http://blog.csdn.net/fightforyourdream/article/details/17707187
public class ScrambleString
{
    //recursion
    public boolean isScrambleRec(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        if (s1.length() == 1)
        {
            return s1.charAt(0) == s2.charAt(0);
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!new String(c1).equals(new String(c2)))
        {
            return false;
        }

        for (int i = 1; i < s1.length(); i++)
        {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if (isScrambleRec(s11, s21) && isScrambleRec(s12, s22))
            {
                return true;
            }

            s21 = s2.substring(0, s2.length() - i);
            s22 = s2.substring(s2.length() - i);
            if (isScrambleRec(s11, s22) && isScrambleRec(s12, s21))
            {
                return true;
            }
        }
        return false;
    }

    //DP
    //dp[k][i][j] means whether s1[i ... i + k] is scramble from s2[j ... j + k];
    public boolean isScrambleDP(String s1, String s2)
    {
        int len = s1.length();
        if (s1.length() != s2.length())
        {
            return false;
        }
        if (s1.length() == 0)
        {
            return true;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        boolean[][][] dp = new boolean[len][len][len];
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                dp[0][i][j] = c1[i] == c2[j];
            }
        }

        for (int k = 2; k <= len; k++)
        {
            for (int i = len - k; i >= 0; i--)
            {
                for (int j = len - k; j >= 0; j--)
                {
                    boolean canTransform = false;
                    for (int m = 1; m < k; m++)
                    {
                        canTransform = (dp[m - 1][i][j] && dp[k - m - 1][i + m][j + m]) || (dp[m - 1][i][j + k - m] && dp[k - m - 1][i + m][j]);
                        if (canTransform)
                        {
                            break;
                        }
                    }
                    dp[k - 1][i][j] = canTransform;
                }
            }
        }

        return dp[len - 1][0][0];
    }
}
