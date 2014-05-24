package InterviewCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum
{
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0)
        {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result)
    {
        if (target < 0)
        {
            return;
        }
        if (target == 0)
        {
            result.add(new ArrayList<Integer>(item));
        }
        for (int i = start; i < candidates.length; i++)
        {
            item.add(candidates[i]);
            helper(candidates, i, target - candidates[i], item, result);
            item.remove(item.size() - 1);
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
