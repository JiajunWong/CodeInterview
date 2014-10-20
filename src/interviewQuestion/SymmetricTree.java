package interviewQuestion;

import util.TreeNode;

public class SymmetricTree
{
    public static boolean isSymmetricTree(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        return isSymmetricTree(root.left, root.right);
    }

    private static boolean isSymmetricTree(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
        {
            return true;
        }
        else if (left == null || right == null || left.val != right.val)
        {
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }
}
