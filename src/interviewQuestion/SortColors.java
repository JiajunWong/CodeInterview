package interviewQuestion;

public class SortColors
{
    public void sortColors(int[] A)
    {
        int len = A.length;
        int start = 0, it = 0, end = len - 1;
        while (it <= end)
        {
            if (A[it] == 0)
            {
                swap(A, start++, it++);
            }
            else if (A[it] == 2)
            {
                swap(A, it, end--);
            }
            else
            {
                it++;
            }
        }
    }

    private void swap(int[] A, int a, int b)
    {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }
}
