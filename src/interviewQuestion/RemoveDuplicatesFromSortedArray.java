package interviewQuestion;

public class RemoveDuplicatesFromSortedArray
{
    public int removeDuplicates(int[] A)
    {
        if (A.length == 0 || A.length == 1)
        {
            return A.length;
        }
        int i = 1, j = 0;
        while (i < A.length)
        {
            if (A[i] == A[j])
            {
                i++;
            }
            else
            {
                A[++j] = A[i++];
            }
        }
        return j + 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
