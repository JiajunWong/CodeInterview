package interviewQuestion;

public class ClimbingStairs
{
    public int climbStairs(int n)
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++)
        {
            int temp = q;
            q += p;
            p = temp;
        }
        return q;
    }
}
