package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
    public List<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0)
        {
            return result;
        }
        dfs(n, n, "", result);
        return result;
    }

    private void dfs(int l, int r, String s, ArrayList<String> result)
    {
        if (r < l)
        {
            return;
        }
        if (r == 0 && l == 0)
        {
            result.add(s);
            return;
        }
        if (l > 0)
        {
            dfs(l - 1, r, s + "(", result);
        }
        if (r > 0)
        {
            dfs(l, r - 1, s + ")", result);
        }
    }
}
