package InterviewCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII
{
    public List<List<Integer>> combinationSum2(int[] num, int target)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num, target, result, array, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, ArrayList<List<Integer>> result, ArrayList<Integer> array, int index)
    {

        if (target < 0)
        {
            return;
        }

        if (target == 0)
        {
            if (!result.contains(array))
                result.add(new ArrayList<Integer>(array));
            return;
        }

        for (int i = index; i < candidates.length; i++)
        {
            array.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, array, i + 1);
            array.remove(array.size() - 1);
        }
    }
}
