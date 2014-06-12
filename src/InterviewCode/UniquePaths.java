package InterviewCode;

public class UniquePaths
{
    public int uniquePaths(int m, int n)
    {
        if (n == 1 || m == 1)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
