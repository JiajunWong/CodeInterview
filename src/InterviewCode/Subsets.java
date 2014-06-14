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
}
