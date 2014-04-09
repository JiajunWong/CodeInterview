package InterviewCode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Zero3Sum
{
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num.length < 3)
        {
            return result;
        }

        TreeSet<Integer> hashSet = new TreeSet<Integer>();
        for (int i = 0; i < num.length; i++)
        {
            hashSet.add(num[i]);
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>(hashSet);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size() - 2; i++)
        {
            int counterNum = -numbers.get(i);
            int start = i + 1;
            int end = numbers.size() - 1;

            while (start < end)
            {
                if (numbers.get(start) + numbers.get(end) == counterNum)
                {
                    arrayList.add(numbers.get(i));
                    arrayList.add(numbers.get(start));
                    arrayList.add(numbers.get(end));

                    result.add(arrayList);
                    start++;
                    end--;
                }
                else if (numbers.get(start) + numbers.get(end) < counterNum)
                {
                    start++;
                }
                else
                {
                    end--;
                }
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int[] num = new int[] { -13, 11, 11, 0, -5, -14, 12, -11, -11, -14, -3, 0, -3, 12, -1, -9, -5, -13, 9, -7, -2, 9, -1, 4, -6, -13, -7, 10, 10, 9, 7, 13, 5, 4, -2, 7, 5, -13, 11, 10, -12, -14, -5, -8, 13, 2, -2, -14, 4, -8, -6, -13, 9, 8, 6, 10, 2, 6, 5, -10, 0, -11, -12, 12, 8, -7, -4, -9, -13, -7, 8, 12, -14, 10, -10, 14, -3, 3, -15, -14, 3, -14, 10, -11, 1, 1, 14, -11, 14, 4, -6, -1, 0, -11, -12, -14, -11, 0, 14, -9, 0, 7, -12, 1, -6 };
        ArrayList<ArrayList<Integer>> result = threeSum(num);
        for (ArrayList<Integer> arrayList : result)
        {
            for (int i : arrayList)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
