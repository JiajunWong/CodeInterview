package interviewQuestion;

public class InterleavingString
{
    //!!!!!!!!careful for the "=" in for loop!!
    public boolean isInterleave(String s1, String s2, String s3)
    {
        if (s1.length() + s2.length() != s3.length())
        {
            return false;
        }
        boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
        matched[0][0] = true;
        for (int i = 1; i <= s1.length(); i++)
        {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
            {
                matched[i][0] = true;
            }
        }
        for (int i = 1; i <= s2.length(); i++)
        {
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
            {
                matched[0][i] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++)
        {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++)
            {
                int k = i + j;
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(k - 1);
                if (c1 == c3)
                {
                    matched[i][j] |= matched[i - 1][j];
                }
                if (c2 == c3)
                {
                    matched[i][j] |= matched[i][j - 1];
                }
            }
        }
        return matched[s1.length()][s2.length()];
    }
}
