package interviewQuestion;


public class JumpGameII
{
    public int jump(int[] A)
    {
        int result = 0;
        int last = 0;
        int curr = 0;

        for (int i = 0; i < A.length; i++)
        {
            if (i > last)
            {
                last = curr;
                result++;
            }
            curr = Math.max(curr, i + A[i]);
        }
        return result;
    }
}
