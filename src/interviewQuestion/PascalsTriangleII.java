package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII
{
    public List<Integer> getRow(int rowIndex)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0)
        {
            return result;
        }
        result.add(1);
        for (int i = 1; i <= rowIndex; i++)
        {
            for (int j = result.size() - 1; j > 0; j--)
            {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }
}
