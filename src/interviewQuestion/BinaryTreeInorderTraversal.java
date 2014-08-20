package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

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
}
