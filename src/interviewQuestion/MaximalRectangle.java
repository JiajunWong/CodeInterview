package interviewQuestion;

//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
public class MaximalRectangle
{
    public int maximalRectangle(char[][] matrix)
    {
        if (matrix.length == 0)
            return 0;
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            d[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < n; j++)
            {
                d[i][j] = matrix[i][j] == '1' ? d[i][j - 1] + 1 : 0;
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                res = Math.max(res, expand(d, i, j));
            }
        }
        return res;
    }

    private int expand(int[][] d, int I, int J)
    {
        int height = 0;
        int width = d[I][J];
        //go up
        for (int i = I - 1; i >= 0; i--)
        {
            if (d[i][J] >= width)
            {
                height++;
            }
            else
            {
                break;
            }
        }
        //go down
        for (int i = I; i < d.length; i++)
        {
            if (d[i][J] >= width)
            {
                height++;
            }
            else
            {
                break;
            }
        }
        return width * height;
    }
}
