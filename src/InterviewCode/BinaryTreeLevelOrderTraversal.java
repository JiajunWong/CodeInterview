package InterviewCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

public class BinaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
        {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        queue.add(root);
        int num = 0;
        while (!queue.isEmpty())
        {
            num = queue.size();
            arrayList.clear();
            for (int i = 0; i < num; i++)
            {
                TreeNode treeNode = queue.remove();
                arrayList.add(treeNode.val);
                if (treeNode.left != null)
                {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null)
                {
                    queue.add(treeNode.right);
                }
            }
            result.add(new ArrayList<Integer>(arrayList));
        }
        return result;
    }
}
