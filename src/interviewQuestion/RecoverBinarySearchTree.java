package interviewQuestion;

import util.TreeNode;

public class RecoverBinarySearchTree
{
    TreeNode pre;
    TreeNode first;
    TreeNode second;

    private void inorder(TreeNode root)
    {
        if (root == null)
            return;
        inorder(root.left);
        if (pre == null)
        {
            pre = root;
        }
        else
        {
            if (pre.val > root.val)
            {
                if (first == null)
                {
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }

    public void recoverTree(TreeNode root)
    {
        pre = null;
        first = null;
        second = null;
        inorder(root);
        if (first != null && second != null)
        {
            int tem = first.val;
            first.val = second.val;
            second.val = tem;
        }
    }
}
