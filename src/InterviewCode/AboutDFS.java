package InterviewCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Util.TreeNode;

public class AboutDFS
{
    //Letter Combinations of a Phone Number
    public List<String> letterCombinations(String digits)
    {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ArrayList<String> result = new ArrayList<String>();
        char[] chars = new char[digits.length()];
        dfs(digits, 0, result, chars, map);
        return result;
    }

    private void dfs(String digits, int index, ArrayList<String> result, char[] chars, HashMap<Character, String> map)
    {
        if (index == digits.length())
        {
            result.add(new String(chars));
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++)
        {
            chars[index] = letters.charAt(i);
            dfs(digits, index + 1, result, chars, map);
        }
    }

    //Generate Parentheses 
    public List<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0)
        {
            return result;
        }
        String s = new String();
        dfs(n, n, s, result);
        return result;
    }

    private void dfs(int l, int r, String s, ArrayList<String> result)
    {
        if (r < l)
        {
            return;
        }
        if (l == 0 && r == 0)
        {
            result.add(s);
        }
        if (l >= 1)
        {
            dfs(l - 1, r, s + "(", result);
        }
        if (r >= 1)
        {
            dfs(l, r - 1, s + ")", result);
        }
    }

    //Sudoku Solver
    public void solveSudoku(char[][] board)
    {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j)
    {
        if (j >= 9)
        {
            return dfs(board, i + 1, 0);
        }
        if (i == 9)
        {
            return true;
        }
        if (board[i][j] == '.')
        {
            for (int k = 1; k <= 9; k++)
            {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j))
                {
                    if (dfs(board, i, j + 1))
                    {
                        return true;
                    }
                }
                board[i][j] = '.';
            }
        }
        else
        {
            return dfs(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j)
    {
        for (int k = 0; k < 9; k++)
        {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int k = 0; k < 9; k++)
        {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)
        {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++)
            {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }

    //N-Queens
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

    //N-Queens II
    public int totalNQueens(int n)
    {
        int[] result = new int[1];
        if (n <= 0)
        {
            return result[0];
        }
        String[] rows = new String[n];
        dfs(0, n, rows, result);
        return result[0];
    }

    private void dfs(int row, int n, String[] rows, int[] result)
    {
        if (row >= n)
        {
            result[0] += 1;
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

    //Word Search
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

    //Restore IP Addresses
    public List<String> restoreIpAddresses(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
        {
            return result;
        }
        dfs(s, "", result, 0);
        return result;
    }

    private void dfs(String s, String tmp, ArrayList<String> result, int count)
    {
        if (count == 3 && isValidIP(s))
        {
            result.add(tmp + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++)
        {
            String substr = s.substring(0, i);
            if (isValidIP(substr))
            {
                dfs(s.substring(i), tmp + substr + '.', result, count + 1);
            }
        }
    }

    private boolean isValidIP(String s)
    {
        if (s.charAt(0) == '0')
        {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }

    public boolean isValidBST(TreeNode root)
    {
        return isValidate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //Validate Binary Search Tree
    private boolean isValidate(TreeNode root, int min, int max)
    {
        if (root == null)
        {
            return true;
        }
        if (min >= root.val || max <= root.val)
        {
            return false;
        }
        return isValidate(root.left, min, root.val) && isValidate(root.right, root.val, max);
    }
}
