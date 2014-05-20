package InterviewCode;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens
{
    public ArrayList<String[]> solveNQueens(int n)
    {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n < 1)
        {
            return result;
        }
        String[] rows = new String[n];
        int row = 0;
        solutions(row, n, rows, result);
        return result;
    }

    private void solutions(int row, int n, String[] rows, ArrayList<String[]> result)
    {
        if (row >= n)
        {
            result.add(rows.clone());
            return;
        }

        for (int col = 0; col < n; col++)
        {
            if (!isValid(col, row, rows))
            {
                continue;
            }

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';

            rows[row] = String.valueOf(chars);
            solutions(row + 1, n, rows, result);
        }
    }

    private boolean isValid(int col, int row, String[] rows)
    {
        for (int i = 0; i < row; i++)
        {
            int indexQ = rows[i].indexOf('Q');
            if (indexQ == col)
                return false;

            int rowDistance = Math.abs(row - i);
            int colDistance = Math.abs(col - indexQ);
            if (rowDistance == colDistance)
                return false;
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
