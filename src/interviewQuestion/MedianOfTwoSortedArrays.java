package interviewQuestion;

//http://blog.csdn.net/yutianzuijin/article/details/11499917
public class MedianOfTwoSortedArrays
{
    double findMedianSortedArrays(int A[], int m, int B[], int n)
    {
        int i = 0, j = 0, median = m + n;
        double prev = 0, last = 0;

        if (median < 2)
        {
            if (m == 0 && n == 0)
                return 0;
            if (m == 1)
                return A[0];
            else
                return B[0];
        }

        while ((i + j) <= (median / 2))
        {
            prev = last;
            if (i >= m)
            {
                last = B[j];
                j++;
            }
            else if (j >= n)
            {
                last = A[i];
                i++;
            }
            else if (A[i] < B[j])
            {
                last = A[i];
                i++;
            }
            else
            {
                last = B[j];
                j++;
            }
        }

        //even
        if ((median & 1) == 0)
            return (prev + last) / 2.0;
        else
            return last;
    }

}
