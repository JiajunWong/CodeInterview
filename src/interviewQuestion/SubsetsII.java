package interviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//http://blog.csdn.net/u011095253/article/details/9158397
public class SubsetsII
{
    public List<List<Integer>> subsetsWithDup(int[] num)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        Arrays.sort(num);
        result.add(array);
        dfs(result, array, num, 0);
        return result;
    }

    private void dfs(ArrayList<List<Integer>> result, ArrayList<Integer> array, int[] num, int index)
    {
        for (int i = index; i < num.length; i++)
        {
            array.add(num[i]);
            result.add(new ArrayList<Integer>(array));
            dfs(result, array, num, i + 1);
            array.remove(array.size() - 1);
            while (i < num.length - 1 && num[i] == num[i + 1])
            {
                i++;
            }
        }
    }
}
