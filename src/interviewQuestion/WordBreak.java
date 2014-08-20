package interviewQuestion;

import java.util.Set;

//TODO: wrong answer;
public class WordBreak
{
    public boolean wordBreak(String s, Set<String> dict)
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
