package InterviewCode;
import java.text.ParseException;
import java.text.SimpleDateFormat;


//1. count negative numbers, let's say K
//2. find the first negative with index k > K
//3. keep 2 pointers i,j , i tracking positives from the start, j tracking negatives starting from k. swap A[i], A[j] and switch their signs (A[i] = -A[j], A[j] = -A[i])
//4. repeat steps 1,2,3 for A[0:K] and A[K,N] seperately
//5. fix all signs (we know that the K first should be negatives and the rest positives)

public class SpecialSort
{
    public static int[] getSort(int[] a)
    {
        int negCounter = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] < 0)
            {
                negCounter++;
                System.out.println("negCounter: "+negCounter);
            }
        }

        int posPointer = 0;
        int negPointer = negCounter;
        while (posPointer <= negCounter - 1)
        {
            while(negPointer <= a.length - 1){
                if (a[posPointer] < 0)
                {
                    posPointer++;
                }
                if (a[negPointer] > 0)
                {
                    negPointer++;
                }
                swap(a, posPointer, negPointer);
                posPointer++;
                negPointer++;
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j)
    {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public static void main(String[] args)
    {
        int[] a = { 1, -3, -2, -6, 7, 8, -1, 4, 9 };
        int[] b = getSort(a);
        for (int i = 0; i < b.length; i++)
        {
            System.out.print(b[i] + ", ");
        }
        
    }
}
