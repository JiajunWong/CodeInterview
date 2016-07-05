package interviewQuestion.arrays;

import util.ArraysUtil;

/**
 * [1, 2, 9] + 1 -> [1, 3, 0]
 *
 * Created by Jiajun Wang on 7/4/16.
 */
public class IncreaseABigInteger
{
    public static int[] plusOne(int[] A)
    {
        int[] tem = new int[A.length + 1];
        int plusOne = A[A.length - 1] + 1;
        int carry = plusOne / 10;
        tem[tem.length - 1] = plusOne % 10;

        for (int i = A.length - 2; i >= 0; i--)
        {
            int result = A[i] + carry;
            tem[i + 1] = result % 10;
            carry = result / 10;
        }

        if (carry > 0)
        {
            tem[0] = carry;
        }

        return tem;
    }

    public static void main(String[] params)
    {
        int[] a = { 1, 2, 9 };
        int[] b = { 9, 9 };
        int[] c = { 1, 2, 4, 5, 6, 7, 9, 9 };

        ArraysUtil.print(plusOne(a));
        System.out.println();
        ArraysUtil.print(plusOne(b));
        System.out.println();
        ArraysUtil.print(plusOne(c));
    }
}
