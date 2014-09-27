package interviewQuestion;

public class PowXN
{
    public double pow(double x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        if (n < 0)
        {
            return 1.0 / power(x, -n);
        }
        else
        {
            return power(x, n);
        }
    }

    private double power(double x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        double tem = power(x, n / 2);
        if (n % 2 == 0)
        {
            return tem * tem;
        }
        else
        {
            return tem * tem * x;
        }
    }
}
