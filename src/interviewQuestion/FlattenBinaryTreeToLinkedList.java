package interviewQuestion;

import java.util.Stack;

import util.TreeNode;

public class FlattenBinaryTreeToLinkedList
{
    public void flatten(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.empty())
        {

            if (p.right != null)
            {
                stack.push(p.right);
            }

            if (p.left != null)
            {
                p.right = p.left;
                p.left = null;
            }
            else if (!stack.empty())
            {
                TreeNode temp = stack.pop();
                p.right = temp;
            }

            p = p.right;
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
        flattenRec(root.left);
        flattenRec(savedRight);
    }
}
