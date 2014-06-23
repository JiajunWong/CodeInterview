package InterviewCode;

public class ValidPalindrome
{
    public boolean isPalindrome(String s)
    {
        if (s == null || s.length() < 2)
        {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end)
        {
            char i = s.charAt(start), j = s.charAt(end);
            while (!isValid(s.charAt(start)) && start < s.length())
            {
                start++;
                i = s.charAt(start);
            }
            while (!isValid(s.charAt(end)) && end > 0)
            {
                end--;
                j = s.charAt(end);
            }
            if (start >= end)
            {
                break;
            }
            if (!isEqual(i, j))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isValid(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return true;
        }
        else if (c >= 'a' && c <= 'z')
        {
            return true;
        }
        else if (c >= 'A' && c <= 'Z')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isEqual(char a, char b)
    {
        if ((a >= '0' && a <= '9') && (b >= '0' && b <= '9'))
        {
            return a == b;
        }
        else if (Character.toLowerCase(a) == Character.toLowerCase(b))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
