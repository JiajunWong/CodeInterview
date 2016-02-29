package interviewQuestion;

import java.util.HashMap;

public class TwoSum
{
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        if (nums == null || nums.length < 2)
        {
            return result;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (map.get(target - nums[i]) != null)
            {
                result[0] = map.get(target - nums[i]) + 1;
                result[1] = i + 1;
            }
            map.put(nums[i], i);
        }

        return result;
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
