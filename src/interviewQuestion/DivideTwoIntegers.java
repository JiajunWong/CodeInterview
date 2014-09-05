package interviewQuestion;

public class DivideTwoIntegers
{
    public int divide(int dividend, int divisor)
    {
        if (dividend == 0 || divisor == 0)
        {
            return 0;
        }
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        if (b > a)
        {
            return 0;
        }

        long sum = 0;
        long pow = 0;
        int result = 0;
        while (a > b)
        {
            pow = 1;
            sum = b;
            while (sum + sum <= a)
            {
                sum += sum;
                pow += pow;
            }
            a -= sum;
            result += pow;
        }
        return isNeg ? -result : result;
    }

    public int divideII(int dividend, int divisor)
    {
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long absDividend = dividend < 0 ? 0 - (long) dividend : (long) dividend;
        long absDivisor = divisor < 0 ? 0 - (long) divisor : (long) divisor;
        int result = dividePositive(absDividend, absDivisor, absDivisor);
        return positive ? result : 0 - result;
    }

    private int dividePositive(long p, long q, long originalDivisor)
    { // p / q
        if (p < q)
            return 0;
        int result = 0;
        int e = 0;
        while (p >= q)
        {
            result += 1 << e;
            p -= q;
            q = q << 1;
            e++;
        }
        return p > 0 ? result + dividePositive(p, originalDivisor, originalDivisor) : result;
    }
}
