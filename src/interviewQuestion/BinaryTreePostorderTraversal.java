package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;


public class BinaryTreePostorderTraversal
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
        {
            return result;
        }
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
}
