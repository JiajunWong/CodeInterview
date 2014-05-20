package InterviewCode;

import java.util.HashSet;

public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board)
    {
        HashSet<Character> checker;
        for (int i = 0; i < board.length; i++)
        {
            checker = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] != '.' && !checker.add(board[i][j]))
                {
                    return false;
                }
            }
        }

        for (int i = 0; i < board[0].length; i++)
        {
            checker = new HashSet<Character>();
            for (int j = 0; j < board.length; j++)
            {
                if (board[j][i] != '.' && !checker.add(board[j][i]))
                {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                checker = new HashSet<Character>();
                for (int m = i * 3; m < i * 3 + 3; m++)
                {
                    for (int n = j * 3; n < j * 3 + 3; n++)
                    {
                        if (board[m][n] != '.' && !checker.add(board[m][n]))
                        {
                            return false;
                        }
                    }
                }
            }
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
