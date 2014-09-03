package interviewQuestion;

public class ReverseInteger
{
    public static int reverse(int x)
    {
        boolean flag = false;
        if (x < 0)
        {
            x = -x;
            flag = true;
        }

        int offset = 0;
        int result = 0;
        int left = x;
        while (left >= 10)
        {
            offset = left % 10;
            left = left / 10;
            result = offset + result * 10;
        }
        offset = left % 10;
        result = result * 10 + offset;

        if (flag)
        {
            result = -result;
        }

        return result;
    }

    public int reverseII(int x)
    {
        boolean isNeg = false;
        if (x < 0)
        {
            isNeg = true;
            x = -x;
        }
        StringBuilder sb = new StringBuilder(new Integer(x).toString());
        int result = Integer.parseInt(sb.reverse().toString());
        if (isNeg)
        {
            result = -result;
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int i = -54321;
        int result = reverse(i);
        System.out.println(result);
    }

}
