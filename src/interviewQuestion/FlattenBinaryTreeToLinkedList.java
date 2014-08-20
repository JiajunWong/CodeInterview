package interviewQuestion;

import java.util.Stack;

import util.TreeNode;


public class FlattenBinaryTreeToLinkedList
{
    public void flatten(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty())
        {
            //TODO: miss something ..
            while (cur.left != null)
            {
                if (cur.right != null)
                {
                    stack.push(cur.right);
                }
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }

            if (cur.right == null && !stack.isEmpty())
            {
                cur.right = stack.pop();
            }
            cur = cur.right;
        }
    }

    //recursive
    private TreeNode lastVisit = null;

    public void flattenRec(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        TreeNode savedRight = root.right;
        if (lastVisit != null)
        {
            lastVisit.left = null;
            lastVisit.right = root;
        }
        lastVisit = root;
        flatten(root.left);
        flatten(savedRight);
    }
}
