package InterviewCode;

//http://blog.csdn.net/ljphhj/article/details/22573983
public class PalindromePartitioningII
{
    public int minCut(String s)
    {
        int min = 0;
        int length = s.length();
        boolean[][] matrix = new boolean[length][length];
        int cuts[] = new int[length + 1];

        if (s == null || s.length() == 0)
        {
            return 0;
        }

        for (int i = 0; i < length; i++)
        {
            cuts[i] = length - i;
        }

        for (int i = length - 1; i >= 0; i--)
        {
            for (int j = i; j < length; j++)
            {
                if ((j - i < 2 && s.charAt(j) == s.charAt(i)) || (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1]))
                {
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        min = cuts[0];
        return min - 1;
    }
}
