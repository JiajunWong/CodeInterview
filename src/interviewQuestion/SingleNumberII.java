package interviewQuestion;

import java.util.HashMap;
import java.util.Iterator;

public class SingleNumberII
{
    public int singleNumber(int[] A)
    {
        if (A == null || A.length == 0)
        {
            return -1;
        }
        if (A.length == 1)
        {
            return A[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++)
        {
            if (!map.containsKey(A[i]))
            {
                map.put(A[i], 1);
            }
            else
            {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext())
        {
            int i = it.next();
            if (map.get(i) != 3)
            {
                return i;
            }
        }
        return -1;
    }
}
