package InterviewCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    }
}
