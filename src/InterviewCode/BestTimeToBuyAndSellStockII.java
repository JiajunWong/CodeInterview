package InterviewCode;

public class BestTimeToBuyAndSellStockII
{
    public int maxProfit(int[] prices)
    {
        int total = 0;
        for (int i = 1; i < prices.length; i++)
        {
            int data = prices[i] - prices[i - 1];
            if (data > 0)
            {
                total += data;
            }
        }
        return total;
    }
}
