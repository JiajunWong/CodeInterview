package interviewQuestion;

public class WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j)
    {
        if (index == word.length() - 1 && word.charAt(word.length() - 1) == board[i][j])
        {
            return true;
        }
        if (word.charAt(index) != board[i][j])
        {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '.';
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        if (i - 1 >= 0 && board[i - 1][j] != '.')
        {
            b1 = dfs(board, word, index + 1, i - 1, j);
        }
        if (!b1 && j - 1 >= 0 && board[i][j - 1] != '.')
        {
            b2 = dfs(board, word, index + 1, i, j - 1);
        }
        if (!b1 && !b2 && i + 1 < board.length && board[i + 1][j] != '.')
        {
            b3 = dfs(board, word, index + 1, i + 1, j);
        }
        if (!b1 && !b2 && b3 && j + 1 < board[0].length && board[i][j + 1] != '.')
        {
            b4 = dfs(board, word, index + 1, i, j + 1);
        }
        board[i][j] = temp;
        return b1 || b2 || b3 || b4;
    }
}
