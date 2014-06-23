package InterviewCode;

import Util.TreeNode;

public class BinaryTreeMaximumPathSum
{
    public int maxPathSum(TreeNode root)
    {
        int[] max = { Integer.MIN_VALUE };
        rec(root, max);
        return max[0];
    }

    private int rec(TreeNode root, int[] max)
    {
        if (root == null)
        {
            return 0;
        }
        int leftSubMaxSum = rec(root.left, max);
        int rightSubMaxSum = rec(root.right, max);
        int arch = leftSubMaxSum + root.val + rightSubMaxSum;

        int maxPathAcrossRootToParent = Math.max(root.val, Math.max(leftSubMaxSum, rightSubMaxSum) + root.val);
        max[0] = Math.max(max[0], Math.max(arch, maxPathAcrossRootToParent));
        return maxPathAcrossRootToParent;
    }
}
