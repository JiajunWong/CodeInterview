package test;

import util.TreeNode;

public class SumRootToLeafNumbersTest
{
    public static int sumNumbers(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        Integer result = new Integer(0);
        int cur = 0;
        dfs(root, result, cur);
        return result;
    }

    private static void dfs(TreeNode root, int result, int cur)
    {
        if (root.left == null && root.right == null)
        {
            result = cur * 10 + root.val;
            return;
        }
        if (root.left != null)
        {
            dfs(root.left, result, cur * 10 + root.val);
        }
        if (root.right != null)
        {
            dfs(root.right, result, cur * 10 + root.val);
        }
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(9);
        System.out.println(sumNumbers(root));
    }
}
