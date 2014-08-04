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

    //another version:
    public int[] searchRange2(int[] A, int target)
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[2];
        ret[0] = search_left_most(A, target);
        ret[1] = search_right_most(A, target);
        return ret;
    }

    public int search_left_most(int[] A, int target)
    {
        int left = 0;
        int right = A.length - 1;
        while (right >= left)
        {
            int mid = (right + left) / 2;
            if (A[mid] == target)
            {
                if (mid == 0)
                    return mid;
                if (A[mid - 1] == target)
                    right = mid - 1;
                else
                    return mid;
            }
            else if (A[mid] > target)
            {
                right = mid - 1;
            }
            else if (A[mid] < target)
            {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search_right_most(int[] A, int target)
    {
        int left = 0;
        int right = A.length - 1;
        while (right >= left)
        {
            int mid = (right + left) / 2;
            if (A[mid] == target)
            {
                if (mid == A.length - 1)
                    return mid;
                if (A[mid + 1] == target)
                    left = mid + 1;
                else
                    return mid;
            }
            else if (A[mid] > target)
            {
                right = mid - 1;
            }
            else if (A[mid] < target)
            {
                left = mid + 1;
            }
        }
        return -1;
    }
}
