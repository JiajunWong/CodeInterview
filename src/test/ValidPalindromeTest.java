package test;

public class ValidPalindromeTest
{
    public static boolean isPalindrome(String s)
    {
        if (s == null || s.length() < 2)
        {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end)
        {
            while (!isValid(s.charAt(start)) && start < end)
            {
                start++;
            }
            while (!isValid(s.charAt(end)) && start < end)
            {
                end--;
            }
            if (!isEqual(s.charAt(start), s.charAt(end)))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isEqual(char a, char b)
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

    private static boolean isValid(char a)
    {
        if (a >= '0' && a <= '9')
        {
            return true;
        }
        else if (a >= 'a' && a <= 'z')
        {
            return true;
        }
        else if (a >= 'A' && a <= 'Z')
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        String s = "ab";
        if (isPalindrome(s))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}
