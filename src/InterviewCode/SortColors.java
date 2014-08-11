package InterviewCode;

public class SortColors
{
    public void sortColors(int[] A)
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int N = A.length;
        int low = 0, it = 0, hi = N - 1;
        while (it <= hi)
        {
            if (A[it] == 0)
            {
                swap(A, low++, it++);
            }
            else if (A[it] == 2)
            {
                swap(A, it, hi--);
            }
            else
            {
                it++;
            }
        }
    }

    private void swap(int[] A, int i, int j)
    {
        int tem = A[i];
        A[i] = A[j];
        A[j] = tem;
    }
}
