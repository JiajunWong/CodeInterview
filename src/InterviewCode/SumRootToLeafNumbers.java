package InterviewCode;

import Util.TreeNode;

public class SumRootToLeafNumbers
{
    public int sumNumbers(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int[] sum = { 0 };
        int current = 0;
        getSum(root, current, sum);
        return sum[0];
    }

    private void getSum(TreeNode root, int current, int[] sum)
    {
        if (root == null)
        {
            return;
        }
        current = current * 10 + root.val;
        if (root.left == null && root.right == null)
        {
            sum[0] = sum[0] + current;
            return;
        }
        getSum(root.left, current, sum);
        getSum(root.right, current, sum);
    }
}
