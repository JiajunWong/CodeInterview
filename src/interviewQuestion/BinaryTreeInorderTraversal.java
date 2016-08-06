package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        rec(root, result);
        return result;
    }

    private void rec(TreeNode root, ArrayList<Integer> result)
    {
        if (root == null)
        {
            return;
        }
        rec(root.left, result);
        result.add(root.val);
        rec(root.right, result);
    }

    private List<Integer> iterative(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null)
        {
            if (p != null)
            {
                stack.push(p);
                p = p.left;
            }
            else
            {
                TreeNode n = stack.pop();
                result.add(n.val);
                p = n.right;
            }
        }
        return result;
    }
}
