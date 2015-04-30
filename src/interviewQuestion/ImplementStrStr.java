package interviewQuestion;

public class ImplementStrStr
{
    public int strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
        {
            return 0;
        }
        if (haystack.length() < needle.length())
        {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle))
            {
                return i;
            }
        }
        return -1;
    }
}
