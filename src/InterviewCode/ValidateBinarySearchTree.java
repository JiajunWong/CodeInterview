package InterviewCode;

import Util.TreeNode;

public class ValidateBinarySearchTree
{
    public boolean isValidBST(TreeNode root)
    {
        return isValidate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidate(TreeNode root, int min, int max)
    {
        if (root == null)
        {
            return true;
        }
        if (min >= root.val || max <= root.val)
        {
            return false;
        }
        return isValidate(root.left, min, root.val) && isValidate(root.right, root.val, max);
    }
}
