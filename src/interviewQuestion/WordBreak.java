package interviewQuestion;

import java.util.Set;

//TODO: wrong answer;
public class WordBreak
{
    //TODO: TLE
    public boolean wordBreakI(String s, Set<String> dict)
    {
        return wordBreakHelper(s, dict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start)
    {
        if (start == s.length())
            return true;

        for (String a : dict)
        {
            int len = a.length();
            int end = start + len;

            //end index should be <= string length
            if (end > s.length())
                continue;

            if (s.substring(start, start + len).equals(a))
                if (wordBreakHelper(s, dict, start + len))
                    return true;
        }

        return false;
    }

    public boolean wordBreakII(String s, Set<String> dict)
    {
        if (s == null || dict.size() == 0)
        {
            return false;
        }
        int len = s.length();
        boolean possible[][] = new boolean[len][len + 1];
        for (int j = 1; j < len; j++)
        {
            for (int i = 0; i < len; i++)
            {
                String t = s.substring(i, i + j);
                if (dict.contains(t))
                {
                    possible[i][j] = true;
                    continue;
                }
                for (int k = 1; k < j; k++)
                {
                    if (possible[i][k] && possible[i + k][j - k])
                    {
                        possible[i][j] = true;
                        break;
                    }
                }
            }
        }
        return possible[0][len];
    }
}
