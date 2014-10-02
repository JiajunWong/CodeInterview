package interviewQuestion;

/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
*/
public class FirstMissingPositive
{
    public static int firstMissingPositive(int[] A)
    {
        int length = A.length;
        if (length == 0 || A == null)
        {
            return 1;
        }
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] > length || A[i] <= 0)
                continue;
            if (A[i] != A[A[i] - 1])
            {
                swap(i, A[i] - 1, A);
                i--;//cause u swiped the two elements u should check the new element to make sure it also has "A[i] != A[A[i] - 1]"
            }
        }
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] - 1 != i)
            {
                return ++i; //watch out! ++i is diff from i++
            }
        }
        return ++length;
    }

    private static void swap(int a, int b, int[] A)
    {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int[] A = { 0 };
        System.out.println(firstMissingPositive(A));
    }

}
