package InterviewCode;

public class SearchA2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int min = 0;
        int max = row * col - 1;

        int x = 0, y = 0;
        while (min <= max)
        {
            int mid = (max - min) / 2 + min;
            x = mid / col;
            y = mid % col;

            if (matrix[x][y] == target)
            {
                return true;
            }
            else if (matrix[x][y] < target)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
        }
        return false;
    }
}
