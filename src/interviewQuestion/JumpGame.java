package interviewQuestion;

public class JumpGame
{
    public boolean canJump(int[] A)
    {
        int maxCover = 0;
        for (int i = 0; i <= maxCover && i < A.length; i++)
        {
            if (A[i] + i > maxCover)
                maxCover = A[i] + i;
            if (maxCover >= A.length - 1)
                return true;
        }
        return false;
    }

    public boolean canJump2(int[] nums)
    {
        int max = 0;
        for (int i = 0; i <= max && max < nums.length - 1; i++)
        {
            if (nums[i] + i > max)
            {
                max = nums[i] + i;
            }
        }
        return max >= nums.length - 1;
    }
}
