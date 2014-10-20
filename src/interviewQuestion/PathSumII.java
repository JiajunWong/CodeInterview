package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;


public class PathSumII
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        return dfs(root, sum, current, result);
    }

    private List<List<Integer>> dfs(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> result)
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
        dfs(root.left, sum - root.val, current, result);
        dfs(root.right, sum - root.val, current, result);
        return result;
    }
}
