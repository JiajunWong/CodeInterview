package InterviewCode;

public class ImplementStrStr
{
    public String strStr(String haystack, String needle)
    {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (haystackLength == needleLength && needleLength == 0)
        {
            return "";
        }
        if (needleLength == 0)
        {
            return haystack;
        }

        for (int i = 0; i < haystackLength; i++)
        {
            if (haystackLength - i + 1 < needleLength)
            {
                return null;
            }

            int k = i;
            int j = 0;

            while (j < needleLength && k < haystackLength && needle.charAt(j) == haystack.charAt(k))
            {
                j++;
                k++;
                if (j == needleLength)
                {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
