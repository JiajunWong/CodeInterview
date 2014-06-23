package InterviewCode;

import Util.TreeNode;

public class MinimumDepthOfBinaryTree
{
    public int minDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int a = minDepth(root.left);
        int b = minDepth(root.right);
        if (a * b != 0)
        {
            return Math.min(a, b) + 1;
        }
        else if (a == 0)
        {
            return b + 1;
        }
        else
        {
            return a + 1;
        }
    }
}
