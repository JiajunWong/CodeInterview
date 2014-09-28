package interviewQuestion;

public class ImplementStrStr
{
    public String strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return haystack;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            int j = 0;
            int k = i;
            while (j < needle.length() && haystack.charAt(k) == needle.charAt(j))
            {
                if (j == needle.length() - 1)
                {
                    return haystack.substring(i);
                }
                j++;
                k++;
            }
        }
        return null;
    }
}
