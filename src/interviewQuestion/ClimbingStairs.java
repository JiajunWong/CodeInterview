package interviewQuestion;

public class ClimbingStairs
{
    public static int climbStairsDP(int n)
    {
        //dp
        //dp[i]: how many ways to reach i.(i < n)
        if (n <= 1)
        {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs(int n)
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

    public static void main(String[] strings)
    {
        System.out.println("DP: " + climbStairsDP(10));
        System.out.println("Simple: " + climbStairs(10));
    }
}
