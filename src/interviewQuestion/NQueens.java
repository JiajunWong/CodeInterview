package interviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens
{
    public List<String[]> solveNQueens(int n)
    {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n <= 0)
        {
            return result;
        }
        String[] rows = new String[n];
        dfs(0, n, rows, result);
        return result;
    }

    private void dfs(int row, int n, String[] rows, ArrayList<String[]> result)
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
            dfs(row + 1, n, rows, result);
        }
    }

    private boolean isValid(int col, int row, String[] rows)
    {
        for (int i = 0; i < row; i++)
        {
            int indexQ = rows[i].indexOf('Q');
            if (indexQ == col)
            {
                return false;
            }

            int rowDis = Math.abs(row - i);
            int colDis = Math.abs(col - indexQ);
            if (rowDis == colDis)
            {
                return false;
            }
        }
        return true;
    }
}
