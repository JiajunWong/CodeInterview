package interviewQuestion.arrays;

import util.ArraysUtil;

/**
 * rearrange the elements in array A, such that all elements less than A[i] appears first, followed by elements equals A[i], followed 
 * by elements larger than A[i]
 *
 * Created by Jiajun Wang on 7/4/16.
 */
public class QuickSortPartition
{
    /**
     * Run time O(n), Space O(1)
     */
    public static void quickSortPartition(int A[], int i)
    {
        // smaller--equal--unclassified--larger
        int smallIndex = 0, equalIndex = 0, largeIndex = A.length - 1;
        //TODO:check why equal
        while (equalIndex <= largeIndex)
        {
            if (A[equalIndex] < i)
            {
                ArraysUtil.swap(A, smallIndex++, equalIndex++);
            }
            else if (A[equalIndex] == i)
            {
                equalIndex++;
            }
            else
            {
                ArraysUtil.swap(A, equalIndex++, largeIndex--);
            }
        }
    }

    public static void main(String[] params)
    {
        int size = 15; int maxValue = 100;
        int[] A = ArraysUtil.randomGenerateArray(size, maxValue);
        ArraysUtil.print(A);
        System.out.println();
        quickSortPartition(A, 56);
        ArraysUtil.print(A);
    }
}
