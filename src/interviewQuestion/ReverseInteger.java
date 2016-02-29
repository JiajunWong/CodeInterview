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
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        long result = Long.parseLong(sb.reverse().toString());
        if (result < Integer.MAX_VALUE)
        {
            if (isNeg)
            {
                result = -result;
            }
            return (int) result;
        }
        else
        {
            return 0;
        }
    }

    public static int reverse1(int x) {
        boolean isNeg = false;
        if (x < 0)
        {
            isNeg = true;
            x = Math.abs(x);
        }

        StringBuilder sb = new StringBuilder(Integer.toString(x));
        double r = Double.parseDouble(sb.reverse().toString());
        if (r > Integer.MAX_VALUE)
        {
            return 0;
        }

        int result = 0;
        while(x > 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if(isNeg){
            return -result;
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int i = -2147483648;
        int result = reverse1(i);
        System.out.println(result);
    }

}
