package interviewQuestion;

public class TrappingRainWater
{
    public int trap(int[] A)
    {
        if (A.length == 0)
        {
            return 0;
        }
        int[] maxL = new int[A.length];
        int[] maxR = new int[A.length];
        maxL[0] = A[0];
        for (int i = 1; i < maxR.length; i++)
        {
            maxL[i] = Math.max(maxL[i - 1], A[i]);
        }
        maxR[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--)
        {
            maxR[i] = Math.max(maxR[i + 1], A[i]);
        }

        int result = 0;
        for (int i = 1; i < A.length - 1; i++)
        {
            result += Math.min(maxL[i], maxR[i]) - A[i];
        }

        return result;
    }
}
