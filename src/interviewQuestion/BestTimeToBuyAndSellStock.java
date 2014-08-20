package interviewQuestion;

public class BestTimeToBuyAndSellStock
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length <= 1)
        {
            return 0;
        }
        int length = prices.length;
        int result = prices[1] - prices[0];
        int min = prices[0];
        for (int i = 2; i < length; i++)
        {
            min = Math.min(min, prices[i - 1]);
            if (result < prices[i] - min)
            {
                result = prices[i] - min;
            }
        }
        if (result < 0)
        {
            return 0;
        }
        return result;
    }
}
