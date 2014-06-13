package InterviewCode;

import java.util.HashMap;

public class MinimumWindowSubstring
{
    public String minWindow(String S, String T)
    {
        HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hasFind = new HashMap<Character, Integer>();
        int count = 0;

        int minBegin = -1;
        int minEnd = S.length();
        for (int i = 0; i < T.length(); i++)
        {
            char c = T.charAt(i);
            if (!needToFind.containsKey(c))
            {
                needToFind.put(c, 1);
                hasFind.put(c, 0);
            }
            else
            {
                needToFind.put(c, needToFind.get(c) + 1);
            }
        }

        for (int begin = 0, end = 0; end < S.length(); end++)
        {
            char c = S.charAt(end);
            if (needToFind.containsKey(c))
            {
                hasFind.put(c, hasFind.get(c) + 1);
                if (hasFind.get(c) <= needToFind.get(c))
                {
                    count++;
                }
                if (count == T.length())
                {
                    while (!needToFind.containsKey(S.charAt(begin)) || hasFind.get(S.charAt(begin)) > needToFind.get(S.charAt(begin)))
                    {
                        if (needToFind.containsKey(S.charAt(begin)) && hasFind.get(S.charAt(begin)) > needToFind.get(S.charAt(begin)))
                        {
                            hasFind.put(S.charAt(begin), hasFind.get(S.charAt(begin)) - 1);
                        }
                        begin++;
                    }
                    if ((end - begin) < (minEnd - minBegin))
                    {
                        minEnd = end;
                        minBegin = begin;
                    }
                }
            }
        }

        return minBegin == -1 ? "" : S.substring(minBegin, minEnd + 1);
    }
}
