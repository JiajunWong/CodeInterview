package InterviewCode;

public class SearchInRotatedSortedArrayII
{
    public static boolean search(int[] A, int target)
    {
        int left = 0;
        int right = A.length - 1;
        while (left <= right)
        {
            int mid = (right - left) / 2 + left;
            if (A[mid] == target)
                return true;

            if (A[left] < A[mid])//left side is sorted
            {
                if (target >= A[left] && target < A[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else if (A[left] > A[mid])//right side is sorted
            {
                if (target > A[mid] && target <= A[right])
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else
            {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] A = { 3, 1, 1 };
        if (search(A, 3))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}
