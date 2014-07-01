package InterviewCode;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

public class BinaryTreePreorderTraversal
{
    public List<Integer> preorderTraversal(TreeNode root)
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
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }
}
