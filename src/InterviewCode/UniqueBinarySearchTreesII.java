package InterviewCode;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

public class UniqueBinarySearchTreesII
{
    public List<TreeNode> generateTrees(int n)
    {
        return dfs(0, n - 1);
    }

    private ArrayList<TreeNode> dfs(int start, int end)
    {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end)
        {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++)
        {
            ArrayList<TreeNode> left = dfs(start, i - 1);
            ArrayList<TreeNode> right = dfs(i + 1, end);

            for (int j = 0; j < left.size(); j++)
            {
                for (int k = 0; k < right.size(); k++)
                {
                    TreeNode root = new TreeNode(i + 1);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
