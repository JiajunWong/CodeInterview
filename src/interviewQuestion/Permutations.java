package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class Permutations
{
    //iterative
    public ArrayList<ArrayList<Integer>> permute(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>()); // add a empty list

        for (int i = 0; i < num.length; i++)
        {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> array : result)
            {
                for (int j = 0; j < array.size() + 1; j++)
                {
                    array.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(array);
                    current.add(temp);
                    array.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }

    //recursive
    public List<List<Integer>> permuteRec(int[] num)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        dfs(result, array, num);
        return result;
    }

    private void dfs(ArrayList<List<Integer>> result, ArrayList<Integer> array, int[] num)
    {
        if (array.size() == num.length)
        {
            result.add(new ArrayList<Integer>(array));
        }
        for (int i = 0; i < num.length; i++)
        {
            if (array.contains(num[i]))
            {
                continue;
            }
            array.add(num[i]);
            dfs(result, array, num);
            array.remove(array.size() - 1);
        }
    }
}
