package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class Combinations
{
    public List<List<Integer>> combine(int n, int k)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        dfs(n, k, result, array, 1);
        return result;
    }

    private void dfs(int n, int k, ArrayList<List<Integer>> result, ArrayList<Integer> array, int index)
    {
        if (array.size() == k)
        {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        for (int i = index; i <= n; i++)
        {
            array.add(i);
            dfs(n, k, result, array, i + 1);
            array.remove(array.size() - 1);
        }
    }
}
