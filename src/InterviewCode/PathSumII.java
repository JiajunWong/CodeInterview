package InterviewCode;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

public class PathSumII
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        return rec(root, sum, current, result);
    }

    private List<List<Integer>> rec(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> result)
    {
        if (root == null)
        {
            return result;
        }
        current.add(root.val);
        if (root.left == null && root.right == null && root.val == sum)
        {
            result.add(current);
        }
        rec(root.left, sum - root.val, current, result);
        rec(root.right, sum - root.val, current, result);
        return result;
    }
}
