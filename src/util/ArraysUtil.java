package util;

import java.util.Random;

/**
 * Created by Jiajun Wang on 7/4/16.
 */
public class ArraysUtil
{
    public static int[] randomGenerateArray(int size, int maxValue)
    {
        Random random = new Random();
        int[] A = new int[size];
        for (int i = 0; i < A.length; i++)
        {
            A[i] = random.nextInt(maxValue);
        }

        return A;
    }

    public static void swap(int A[], int a, int b)
    {
        if (A == null || A.length < 2)
        {
            return;
        }
        int tem = A[a];
        A[a] = A[b];
        A[b] = tem;
    }

    public static void print(int A[])
    {
        for (int i : A)
        {
            System.out.print(i + ", ");
        }
    }
}
