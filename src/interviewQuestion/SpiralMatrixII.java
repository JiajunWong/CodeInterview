package interviewQuestion;

public class SpiralMatrixII
{
    public int[][] generateMatrix(int n)
    {
        int[][] result = new int[n][n];

        if (n <= 0)
            return result;

        int xMin = 0, yMin = 0, xMax = n - 1, yMax = n - 1;
        int number = 1;
        result[0][0] = number;

        int i = 0, j = 0;
        while (true)
        {
            while (i < xMax)
                result[j][++i] = ++number;
            if (++yMin > yMax)
                break;
            while (j < yMax)
                result[++j][i] = ++number;
            if (--xMax < xMin)
                break;
            while (i > xMin)
                result[j][--i] = ++number;
            if (--yMax < yMin)
                break;
            while (j > yMin)
                result[--j][i] = ++number;
            if (++xMin > xMax)
                break;
        }

        return result;
    }
}
