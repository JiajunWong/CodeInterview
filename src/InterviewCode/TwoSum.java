package InterviewCode;

import java.util.HashMap;

public class TwoSum
{
    public static int[] twoSum(int[] numbers, int target)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++)
        {
            //            hashMap.put(numbers[i], i + 1);
            if (hashMap.get(target - numbers[i]) != null)
            {
                if ((hashMap.get(target - numbers[i]) + 1) <= i + 1)
                {
                    return new int[] { hashMap.get(target - numbers[i]) + 1, i + 1 };
                }
                else {
                    return new int[] {i + 1 , hashMap.get(target - numbers[i]) + 1};
                }
            }
            hashMap.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args)
    {
        int[] numbers = new int[] { 3, 2, 4 };
        int target = 6;
        int[] result = twoSum(numbers, target);
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }
}
