package interviewQuestion;

//http://www.cnblogs.com/TenosDoIt/p/3389479.html

/**
 *
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Candy
{
    public int candy(int[] ratings)
    {
        if (ratings == null || ratings.length == 0)
        {
            return 0;
        }
        int len = ratings.length;
        int candys[] = new int[len];
        for (int i = 0; i < len; i++)
        {
            candys[i] = 1;
        }
        for (int i = 1; i < len; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                candys[i] = candys[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1])
            {
                candys[i] = candys[i + 1] + 1;
            }
        }
        int total = 0;
        for (int i : candys)
        {
            total += i;
        }
        return total;
    }
}
