package InterviewCode;

public class SearchInsertPosition
{
    public int searchInsert(int[] A, int target)
    {
        int lower = 0;
        int upper = A.length - 1;

        while (lower <= upper)
        {
            int mid = lower + (upper - lower) / 2;
            if (A[mid] == target)
            {
                return mid;
            }
            else if (A[mid] > target)
            {
                upper = mid - 1;
            }
            else
            {
                lower = mid + 1;
            }
        }

        return lower;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
