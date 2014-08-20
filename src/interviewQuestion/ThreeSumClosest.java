package interviewQuestion;

import java.util.Arrays;

public class ThreeSumClosest
{
    private int dist(int a, int b)
    {
        if (a == b)
            return 0;
        return a > b ? (a - b) : (b - a);
    }

    public int threeSumClosest(int[] num, int target)
    {
        if (num.length < 3)
            return 0; //size check
        //if(num.length == 3) return num[0] + num[1] + num[2];
        Arrays.sort(num); //sort the array

        int result = 0;
        for (int i = 0; i <= num.length - 3; i++)
        {
            int left = target - num[i];
            int leftPointer = i + 1, rightPointer = num.length - 1;
            int compareToLeft = num[leftPointer] + num[rightPointer];
            //should compute 3sum;
            if (i == 0)
                result = compareToLeft + num[i];

            while (leftPointer < rightPointer)
            {
                int temp2sum = num[leftPointer] + num[rightPointer];
                if (dist(temp2sum, left) < dist(compareToLeft, left))
                {
                    compareToLeft = temp2sum;
                }

                if (temp2sum == left)
                    return target;
                else if (temp2sum > left)
                    rightPointer--;
                else
                    leftPointer++;
            }

            int currentResult = num[i] + compareToLeft;
            if (dist(currentResult, target) < dist(result, target))
                result = currentResult;
        }

        return result;
    }

    public int threeSumClosest2(int[] num, int target)
    {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++)
        {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k)
            {
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(sum - target);
                if (diff < min)
                {
                    min = diff;
                    result = sum;
                }
                if (sum < target)
                {
                    j++;
                }
                else if (sum > target)
                {
                    k--;
                }
                else
                {
                    return target;
                }
            }
        }

        return result;
    }
}
