package InterviewCode;

public class Sqrt
{
    public static int sqrt(int x)
    {
        if (x < 0)
        {
            return -1;
        }
        if (x == 0)
        {
            return 0;
        }

        long high = x / 2 + 1;
        long low = 0;
        while (low <= high)
        {
            long mid = low + (high - low) / 2;
            long sp = mid * mid;

            if (sp == x)
            {
                return (int) mid;
            }
            else if (sp < x)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return (int) high;
    }

    public static void main(String[] args)
    {
        int result = sqrt(99);
        System.out.println(result);
    }
}
