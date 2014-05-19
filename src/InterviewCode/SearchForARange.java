package InterviewCode;

import java.util.Arrays;

public class SearchForARange
{
    public static int[] searchRange(int[] A, int target)
    {
        int result[] = new int[2];
        Arrays.fill(result, -1);

        int lower = 0;
        int upper = A.length - 1;

        //search for lower bound;
        while (lower < upper)
        {
            int mid = (lower + upper) / 2;
            if (A[mid] < target)
            {
                lower = mid + 1;
            }
            else
            {
                upper = mid;
            }
        }

        if (A[lower] != target)
        {
            return result;
        }
        result[0] = lower;

        //search upper bound;
        upper = A.length;
        while (lower < upper)
        {
            int mid = (lower + upper) / 2;
            if (A[mid] > target)
            {
                upper = mid;
            }
            else
            {
                lower = mid + 1;
            }
        }

        result[1] = upper - 1;
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int A[] = { 1, 3 };
        int result[] = searchRange(A, 1);
        for (int i : result)
            System.out.println(i);
    }

}
