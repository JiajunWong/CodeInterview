package InterviewCode;

public class RegularExpressionMatching
{
    public static boolean isMatch(String s, String p)
    {
        if (s.length() == 0)
        {
            return p.length() == 0;
        }

        if (p.length() == 1 || p.charAt(1) != '*')
        {
            if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
            {
                return false;
            }
            return isMatch(s.substring(0), p.substring(0));
        }
        else
        {
            int index = -1;

            while (index < s.length() && (index < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(index)))
            {
                if (isMatch(s.substring(index + 1), p.substring(2)))
                {
                    return true;
                }
                index++;
            }
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String s = "aa";
        String p = "a";
        
        System.out.println(isMatch(s, p));
    }

}
