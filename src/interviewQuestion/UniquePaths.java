package interviewQuestion;

public class UniquePaths
{
    public int uniquePaths(int m, int n)
    {
        if (n == 1 || m == 1)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    //https://github.com/rffffffff007/leetcode/blob/master/Unique%20Paths.java
    public int uniquePathsI(int m, int n)
    {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        if (m == 0 && n == 0)
        {
            return 0;
        }
        else
        {
            return dp[m - 1][n - 1];
        }
    }
}
