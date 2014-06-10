package InterviewCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)
        {
            return result;
        }

        int xMin = 0;
        int yMin = 0;
        int xMax = matrix[0].length - 1;
        int yMax = matrix.length - 1;

        result.add(matrix[0][0]);

        int i = 0;
        int j = 0;

        while (true)
        {
            while (i < xMax)
                result.add(matrix[j][++i]);
            if (++yMin > yMax)
                break;
            while (j < yMax)
                result.add(matrix[++j][i]);
            if (--xMax < xMin)
                break;
            while (i > xMin)
                result.add(matrix[j][--i]);
            if (--yMax < yMin)
                break;
            while (j > yMin)
                result.add(matrix[--j][i]);
            if (++xMin > xMax)
                break;
        }

        return result;
    }
}
