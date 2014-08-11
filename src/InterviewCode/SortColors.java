package InterviewCode;

public class SortColors
{
    public void sortColors(int[] A)
    {
<<<<<<< HEAD
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
=======
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
>>>>>>> FETCH_HEAD
            }
            else
            {
                it++;
            }
        }
    }

<<<<<<< HEAD
    private void swap(int[] A, int i, int j)
    {
        int tem = A[i];
        A[i] = A[j];
        A[j] = tem;
=======
    private void swap(int[] A, int a, int b)
    {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
>>>>>>> FETCH_HEAD
    }
}
