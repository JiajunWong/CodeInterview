package InterviewCode;

public class PalindromeNumber
{
    public static boolean isPalindrome(int x)
    {
        if (x < 10 && -10 < x)
        {
            return true;
        }

        int reverse = ReverseInteger.reverse(x);

        if (reverse == x)
        {
            return true;
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int x = 1234321;
        boolean b = isPalindrome(x);
        System.out.println(b);
    }

}
