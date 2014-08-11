package InterviewCode;

//http://www.cnblogs.com/lichen782/p/leetcode_Container_With_Most_Water.html
public class ContainerWithMostWater
{
    public int maxArea(int[] height)
    {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        if (j <= 0)
        {
            return 0;
        }
        while (i < j)
        {
            int a = area(height, i, j);
            if (height[i] < height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
            if (a > max)
                max = a;
        }
        return max;
    }

    private int area(int[] height, int i, int j)
    {
        return Math.min(height[i], height[j]) * Math.abs(j - i);
    }
}
