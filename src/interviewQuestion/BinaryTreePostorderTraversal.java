package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.ListNode;
import util.TreeNode;

public class BinaryTreePostorderTraversal
{
    public List<Integer> postorderTraversal(TreeNode root)
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
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
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
        TreeNode pre = null;

        while (!stack.isEmpty())
        {
            TreeNode cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur)
            {
                if (cur.left != null)
                {
                    stack.push(cur.left);
                }
                else if (cur.right != null)
                {
                    stack.push(cur.right);
                }
                else
                {
                    stack.pop();
                    result.add(cur.val);
                }
            }
            else if (cur.left == pre)
            {
                if (cur.right != null)
                {
                    stack.push(cur.right);
                }
                else
                {
                    stack.pop();
                    result.add(cur.val);
                }
            }
            else
            {
                stack.pop();
                result.add(cur.val);
            }
            pre = cur;
        }

        return result;
    }
}
