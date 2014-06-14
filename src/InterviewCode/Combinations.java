package InterviewCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations
{
    public List<List<Integer>> combine(int n, int k)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (n < k)
        {
            return result;
        }
        helper(n, k, result, arrayList, 1);
        return result;
    }

    private void helper(int n, int k, ArrayList<List<Integer>> result, ArrayList<Integer> arrayList, int index)
    {
        if (arrayList.size() == k)
        {
            result.add(new ArrayList<Integer>(arrayList));
        }
        else
        {
            for (int i = index; i <= n; i++)
            {
                arrayList.add(i);
                helper(n, k, result, arrayList, index + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
}
