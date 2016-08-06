package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class BinaryTreePreorderTraversal
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, ArrayList<Integer> result)
    {
        if (root == null)
        {
            return;
        }
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }

    public List<Integer> iterative(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode n = stack.pop();
            result.add(n.val);

            if (n.right != null)
            {
                stack.push(n.right);
            }

            if (n.left != null)
            {
                stack.push(n.left);
            }
        }

        return result;
    }
}
