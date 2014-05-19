package InterviewCode;

import java.util.Arrays;

public class NextPermutation
{
    public void nextPermutation(int[] num)
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

    /**
     * @param args
     */
    public static void main(String[] args)
    {

    }

}
