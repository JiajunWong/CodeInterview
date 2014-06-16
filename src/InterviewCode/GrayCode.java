package InterviewCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode
{
    public List<Integer> grayCode(int n)
    {
        //可以看到第n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序的和
        if (n == 0)
        {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> tmp = (ArrayList<Integer>) grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--)
        {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }
}
