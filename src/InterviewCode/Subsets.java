package InterviewCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets
{
    public List<List<Integer>> subsets(int[] S)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        for (int i : S)
        {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (List<Integer> arrayList : result)
            {
                temp.add(new ArrayList<Integer>(arrayList));
            }
            for (List<Integer> arrayList : temp)
            {
                arrayList.add(i);
            }
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(i);
            temp.add(arrayList);
            result.addAll(temp);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        result.add(arrayList);
        return result;
    }

    //recursive
    public List<List<Integer>> subsetsRec(int[] S)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        Arrays.sort(S);
        result.add(array);
        dfs(result, array, S, 0);
        return result;
    }

    private void dfs(ArrayList<List<Integer>> result, ArrayList<Integer> array, int[] S, int index)
    {
        for (int i = index; i <= S.length - 1; i++)
        {
            array.add(S[i]);
            result.add(new ArrayList<Integer>(array));
            dfs(result, array, S, i + 1);
            array.remove(array.size() - 1);
        }
    }
}
