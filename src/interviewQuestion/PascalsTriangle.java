package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle
{
    public List<List<Integer>> generate(int numRows)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0)
        {
            return result;
        }
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        for (int i = 1; i < numRows; i++)
        {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++)
            {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            result.add(cur);
            pre = cur;
        }
        return result;
    }
}
