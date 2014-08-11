package InterviewCode;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram
{
    public int largestRectangleArea(int[] height)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length)
        {
            if (stack.isEmpty() || h[stack.peek()] <= h[i])
            {
                stack.push(i++);
            }
            else
            {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] height)
    {
        int max = 0;
        int[] min = new int[height.length];
        for (int i = 0; i < height.length; i++)
        {
            if (height[i] == 0 || max / height[i] >= (height.length - i))
            {
                continue;
            }
            for (int j = i; j < height.length; j++)
            {
                if (i == j)
                    min[j] = height[j];
                else
                {
                    if (height[j] < min[j - 1])
                    {
                        min[j] = height[j];
                    }
                    else
                    {
                        min[j] = min[j - 1];
                    }
                }
                int erea = min[j] * (j - i + 1);
                max = Math.max(max, erea);
            }
        }
        return max;
    }
}
