package interviewQuestion;

import util.TreeNode;

public class BalancedBinaryTree
{
    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
        {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
