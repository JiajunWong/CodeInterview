package interviewQuestion;

import java.util.Arrays;

public class NextPermutation
{
    //    Step 1: Find the largest index k, such that A[k]<A[k+1]. If not exist, this is the last permutation. (in this problem just sort the vector and return.)
    //    Step 2: Find the largest index l, such that A[l]>A[k].
    //    Step 3: Swap A[k] and A[l].
    //    Step 4: Reverse A[k+1] to the end.
    public static void nextPermutation(int[] num)
    {
        if (num.length == 1)
        {
            return;
        }

        int index = num.length - 1;
        while (index > 0)
        {
            if (num[index] > num[index - 1])
            {
                break;
            }
            index--;
        }
        if (index == 0)
        {
            Arrays.sort(num);
            return;
        }
        int k = num.length - 1;
        for (; k >= index; k--)
        {
            if (num[k] > num[index - 1])
            {
                break;
            }
        }
        int temp = num[index - 1];
        num[index - 1] = num[k];
        num[k] = temp;
        Arrays.sort(num, index, num.length);
    }
}
