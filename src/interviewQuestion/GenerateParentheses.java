package interviewQuestion;

import java.util.ArrayList;

public class GenerateParentheses
{
    public ArrayList<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();

        if (n <= 0)
        {
            return result;
        }

        helper(n, n, new String(), result);
        return result;
    }

    private void helper(int l, int r, String string, ArrayList<String> result)
    {
        if (r < l)
        {
            return;
        }
        if (l == 0 && r == 0)
        {
            result.add(string);
        }
        if (l > 0)
        {
            helper(l - 1, r, string + "(", result);
        }
        if (r > 0)
        {
            helper(l, r - 1, string + ")", result);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
